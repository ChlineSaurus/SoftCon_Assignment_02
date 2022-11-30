package Turn.State;

import Turn.Turn;
import exceptions.IllegalUserInputExeption;

import java.util.ArrayList;

public class NoMoreValidDice implements TurnState {
    Turn aTurn;
    public NoMoreValidDice(Turn aTurn){
        this.aTurn = aTurn;
    }

    @Override
    public void next() {
        //Display the current Game State
        aTurn.displayTurn("You can't pick any more Dice. If you want to take the risk of losing " +
                "all your points of this turn, you can reroll your Dice with \"R\" " +
                "if you do not want to risk them enter \"N\"");
        ArrayList<Character> allowedAction = new ArrayList<>();
        allowedAction.add('N');
        allowedAction.add('R');
        char input;
        while(true) {
            try {
                input = Input.TuttoInput.takeRestrictedCharInput(allowedAction);
                break;
            } catch (IllegalUserInputExeption e) {
                UI.Display.displayMessage(e.getMessage());
            }
        }
        String reroll = String.valueOf(input);
        if (reroll.equals("R")){
            aTurn.setCurrentState(new CurrentlyPlaying(aTurn));
        }
        else{
            aTurn.setCurrentState(new EndTurn(aTurn));
        }
    }
}
