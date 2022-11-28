package Turn.State;

import UI.Display;
import players.PlayerManager;

public class EndTurn implements TurnState{
    Turn aTurn;

    public EndTurn(Turn aTurn){this.aTurn = aTurn;}
    @Override
    public void next(Turn aTurn) {
        //Add playerPoints
        PlayerManager playerManager = PlayerManager.getInstance();

        String myEndTurnMessage = "Your turn is over %s now it is the next players turn.",currentPlayerName;

        Display.displayMessage(myEndTurnMessage);


        //nächster Spieler aufrufen
        playerManager.nextPlayersTurn(aTurn.score);

    }
}
