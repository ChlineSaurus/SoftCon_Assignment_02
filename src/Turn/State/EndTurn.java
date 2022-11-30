package Turn.State;

import Turn.Turn;
import UI.Display;

public class EndTurn implements TurnState{
    Turn aTurn;

    public EndTurn(Turn aTurn){this.aTurn = aTurn;}
    @Override
    public void next() {
        String myEndTurnMessage = "Your turn is over, now it is next players turn.";
        Display.displayMessage(myEndTurnMessage);
        aTurn.newTurn();
    }
}