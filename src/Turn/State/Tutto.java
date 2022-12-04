package Turn.State;

import Enums.Msg;
import Input.TuttoInput;
import Turn.Turn;
import UI.Display;
import exceptions.IllegalUserInputException;

import java.util.ArrayList;

public class Tutto implements TurnState{
    Turn aTurn;

    public Tutto(Turn aTurn){this.aTurn = aTurn;}

    @Override
    public void next() {
        aTurn.temporaryScore = aTurn.turnCard.tuttoAchieved(aTurn.temporaryScore);
        aTurn.pointsToDeduct += aTurn.turnCard.getDeductPoints();
        if(aTurn.turnCard.haveToContinueRolling()){
            Display.displayMessage(Msg.tuttoAndCloverleafOrFireworks.message);
            aTurn.newRoll();
            aTurn.setCurrentState(new CurrentlyPlaying(aTurn));
        } else {
            Display.displayMessage(Msg.stopOrContinueQuestion.message);
            ArrayList<Character> allowedAction = new ArrayList<>();
            allowedAction.add('S');
            allowedAction.add('C');
            Character action;
            while(true) {
                try{
                    action = TuttoInput.takeRestrictedCharInput(allowedAction);
                    break;
                } catch (IllegalUserInputException e) {
                    Display.displayMessage(e.getMessage());
                }
            }
            if(action.equals('S')){
                aTurn.setCurrentState(new EndTurn(aTurn));
            }
            else if(action.equals('C')){
                aTurn.draw();
                aTurn.setCurrentState(new CurrentlyPlaying(aTurn));
            }
        }
    }
}
