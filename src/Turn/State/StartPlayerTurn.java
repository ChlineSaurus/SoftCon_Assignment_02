package Turn.State;

import Enums.Msg;
import Input.TuttoInput;
import Turn.Turn;
import UI.Display;
import exceptions.IllegalUserInputException;

import java.util.ArrayList;

public class StartPlayerTurn implements TurnState {
    Turn aTurn;
    public StartPlayerTurn(Turn aTurn){
        this.aTurn = aTurn;
    }

    @Override
    public void next() {
        while(true) {
            try {
                DisplayOrRoll();
                aTurn.setCurrentState(new CurrentlyPlaying(aTurn));
                break;
            } catch (IllegalUserInputException e) {
                UI.Display.displayMessage(e.getMessage());
            }
        }
    }

    private void DisplayOrRoll() throws IllegalUserInputException {
        Character nextAction = null;
        ArrayList<Character> possibleNextAction = new ArrayList<>();
        possibleNextAction.add('R');
        possibleNextAction.add('D');
        UI.Display.displayMessage(Msg.displayOrRollQuestion.message);
        boolean validInput = false;
        while (!validInput) {
            try {
                nextAction = TuttoInput.takeRestrictedCharInput(possibleNextAction);
                validInput = true;
            } catch (IllegalUserInputException e) {
                UI.Display.displayMessage(e.getMessage());
            }
        }
        if (nextAction.equals('D')) {
            Display.displayScores();
            DisplayOrRoll();
        }
    }
}
