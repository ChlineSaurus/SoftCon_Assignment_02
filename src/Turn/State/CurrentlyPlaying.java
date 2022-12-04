package Turn.State;

import Enums.Msg;
import Input.TuttoInput;
import Turn.Turn;
import dice.DiceFace;
import exceptions.IllegalUserInputException;

import java.util.ArrayList;

public class CurrentlyPlaying implements TurnState{
    Turn aTurn;

    public CurrentlyPlaying(Turn pTurn){
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
    private void nullRollAction(){
        if (!aTurn.validDiceExist()) {
            aTurn.displayTurn(Msg.nullRoll.message);
            if (!aTurn.turnCard.isImmunity()) {
                aTurn.temporaryScore = 0;
                aTurn.pointsToDeduct = 0;
            }
            aTurn.setCurrentState(new EndTurn(aTurn));
        }
    }

    private void TurnFlow() {
        while(true) {
            aTurn.rollNotTakenDices();
            if (!aTurn.validDiceExist()) {
                nullRollAction();
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

    private boolean diceRemovalAttempt() throws IllegalUserInputException{

        if (!aTurn.isDiceTakenSinceRoll()) {
            throw new IllegalUserInputException(Msg.takeAtLeastOneValidDice.message);
        } else {
            return true;
        }
    }
    private void takeDice() {
        String message = Msg.explainHowToTakeDice.message;
        while (true) {
            aTurn.displayTurn(message);
            try {
                ArrayList<DiceFace> diceToRemove = TuttoInput.takeDiceListInput();
                if (diceToRemove.size()==0 &&diceRemovalAttempt()){
                    break;
                }
                aTurn.temporaryScore += aTurn.removeDice(diceToRemove);
                if (aTurn.validDiceExist()){
                    message = "If you want to take more Dice enter the Numbers, else press Enter";
                } else {
                    break;
                }
            } catch (IllegalUserInputException e) {
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
            } catch (IllegalUserInputException e) {
                aTurn.displayTurn(e.getMessage());
            }
        }
        return nextAction.equals('R');
    }
}
