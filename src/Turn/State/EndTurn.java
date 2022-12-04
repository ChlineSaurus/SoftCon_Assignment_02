package Turn.State;

import Enums.Msg;
import Turn.Turn;
import players.PlayerManager;

public class EndTurn implements TurnState{
    Turn aTurn;
    PlayerManager playerManager=PlayerManager.getInstance();

    public EndTurn(Turn aTurn){this.aTurn = aTurn;}
    @Override
    public void next() {
        String myEndTurnMessage = Msg.announceNextPlayer.message + playerManager.getNextPlayersName() +
                Msg.decoration.message;
        aTurn.displayTurn(myEndTurnMessage);
        aTurn.newTurn();
    }
}