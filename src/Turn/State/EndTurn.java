package Turn.State;

import Turn.Turn;
import players.PlayerManager;

public class EndTurn implements TurnState{
    Turn aTurn;
    PlayerManager playerManager=PlayerManager.getInstance();

    public EndTurn(Turn aTurn){this.aTurn = aTurn;}
    @Override
    public void next() {
        String myEndTurnMessage = "Your turn is over, now it is " +playerManager.getNextPlayersName() +"'s turn.";
        aTurn.displayTurn(myEndTurnMessage);
        aTurn.newTurn();
    }
}