package Turn.State;

import UI.Display;
import exceptions.IllegalUserInputExeption;

import java.io.IOException;

public class NoMoreValidDice implements TurnState {
    Turn aTurn;
    public NoMoreValidDice(Turn aTurn){
        this.aTurn = aTurn;
    }

    @Override
    public void next(Turn aTurn) throws IOException, IllegalUserInputExeption {
        //Display the current Game State
        Display.displayMessage("You can't pick any more Dice. If you want to take the risk of losing all your points of this turn, you can reroll your Dice with \"R\" if you do not want to risk them enter \"N\"");
        char input = Input.Input.takeCharInput();
        String reroll = String.valueOf(input);
        if (reroll.equals("R")){
            aTurn.setState(new CurrentlyPlaying(aTurn));
        }
        else{
            aTurn.setState(new EndTurn(aTurn));
        }
    }
}
