package Turn.State;

import Input.TuttoInput;
import Turn.Turn;
import cards.cards.cardtypes.Fireworks;
import dice.DiceFace;
import exceptions.IllegalUserInputExeption;

import java.util.ArrayList;

public class CurrentlyPlaying implements TurnState{
    Turn aTurn;
    private boolean interactionFinished = false;

    public CurrentlyPlaying(Turn pTurn){
        assert pTurn!=null;
        this.aTurn = pTurn;
    }
    @Override
    public void next() {
        System.out.println("I am currently playing");
        aTurn.draw();
        if(aTurn.turnCard.isEndTurn()) {
            aTurn.temporaryScore = 0;
            aTurn.setCurrentState(new EndTurn(aTurn));
        }
        TurnFlow();
    }

    //wenns funktioniert, chamer die Methode lösche und d Funktionalität in ManageGame übere tue...
    //evtl. chamer au die ganzi manage game denne lösche...

    private void TurnFlow() {
        while(true) {
            aTurn.rollNotTakenDices();
            if (!aTurn.validDiceExist()) {
                aTurn.displayTurn("You rolled a Null");
                if (!aTurn.turnCard.isImmunity()) {
                    aTurn.temporaryScore = 0;
                    aTurn.pointsToDeduct = 0;
                }
                aTurn.setCurrentState(new EndTurn(aTurn));
            } else {
                takeDice();
                if (aTurn.tuttoMade()) {
                    aTurn.setCurrentState(new Tutto(aTurn));
                    break;
                }
                else if (wantReroll()) {
                    continue;
                } else {
                    aTurn.setCurrentState(new EndTurn(aTurn));
                    break;
                }
            }
        }
    }
    private void takeDice() {
        String message = "Please enter the dice you want to take";
        while (true) {
            aTurn.displayTurn(message);
            try {
                ArrayList<DiceFace> diceToRemove = TuttoInput.takeDiceListInput();
                if (diceToRemove.size() == 0) {
                    if (!aTurn.isDiceTakenSinceRoll()) {
                        throw new IllegalUserInputExeption("You can't exit, you must take at least one Dice");
                    } else if (aTurn.turnCard.getClass().equals(Fireworks.class) && aTurn.validDiceExist()) {
                        throw new IllegalUserInputExeption("Your Card is a Firework and you" +
                                " must take all Dice");
                    } else {
                        break;
                    }
                }
                aTurn.temporaryScore += aTurn.removeDice(diceToRemove);
                if (aTurn.validDiceExist()){
                    message = "If you want to take more Dice enter the Numbers, else press Enter";
                } else {
                    break;
                }
            } catch (IllegalUserInputExeption e) {
                message = e.getMessage();
            }
        }
    }

    public Boolean wantReroll() {
        ArrayList<Character> allowedChar = new ArrayList<>();
        allowedChar.add('E');
        allowedChar.add('R');
        aTurn.displayTurn("Enter to reroll the dice \"R\" and if you want to end your turn \"E\"");
        Character nextAction;
        while(true) {
            try {
                nextAction = TuttoInput.takeRestrictedCharInput(allowedChar);
                if(nextAction.equals('E')) {
                    aTurn.turnCard.userTriesToEndTurn();
                }
                break;
            } catch (IllegalUserInputExeption e) {
                aTurn.displayTurn(e.getMessage());
            }
        }
        return nextAction.equals('R');
    }
}
