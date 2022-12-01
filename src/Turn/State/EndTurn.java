package Turn.State;

import Turn.Turn;

public class EndTurn implements TurnState{
    Turn aTurn;

    public EndTurn(Turn aTurn){this.aTurn = aTurn;}
    @Override
    public void next() {
        String myEndTurnMessage = "Your turn is over, now it is next players turn.";
        aTurn.displayTurn(myEndTurnMessage);
        aTurn.newTurn();
    }
}