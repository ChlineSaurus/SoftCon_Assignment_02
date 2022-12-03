package Turn.State;

import Enums.Msg;
import Input.TuttoInput;
import Turn.Turn;
import dice.DiceFace;
import exceptions.IllegalUserInputExeption;

import java.util.ArrayList;

public class CurrentlyPlaying implements TurnState{
    Turn aTurn;

    public CurrentlyPlaying(Turn pTurn){
        assert pTurn!=null;
        this.aTurn = pTurn;
    }
    @Override
    public void next() {
        if(aTurn.turnCard.isEndTurn()) {
            aTurn.temporaryScore = 0;
            aTurn.setCurrentState(new EndTurn(aTurn));
            return;
        }
        TurnFlow();
    }

    private void TurnFlow() {
        while(true) {
            aTurn.rollNotTakenDices();
            if (!aTurn.validDiceExist()) {
                aTurn.displayTurn(Msg.nullRoll.message);
                if (!aTurn.turnCard.isImmunity()) {
                    aTurn.temporaryScore = 0;
                    aTurn.pointsToDeduct = 0;
                }
                aTurn.setCurrentState(new EndTurn(aTurn));
                break;
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
        String message = Msg.explainHowToTakeDice.message;
        while (true) {
            aTurn.displayTurn(message);
            try {
                ArrayList<DiceFace> diceToRemove = TuttoInput.takeDiceListInput();
                if (diceToRemove.size() == 0) {
                    if (!aTurn.isDiceTakenSinceRoll()) {
                        throw new IllegalUserInputExeption(Msg.takeAtLeastOneValidDice.message);
                    } else if ( !aTurn.validDiceExist()) {
                        throw new IllegalUserInputExeption(Msg.invalidDicesSelected.message);
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
