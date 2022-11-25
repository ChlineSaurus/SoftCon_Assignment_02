package Turn.State;

import UI.Display;

public class EndTurn implements TurnState{
    Turn aTurn;

    public EndTurn(Turn aTurn){this.aTurn = aTurn;}
    @Override
    public void next(Turn aTurn) {
        //Add playerPoints
        String myEndTurnMessage = "Your turn is over %s now it is the next players turn.",currentPlayerName;

        Display.displayMessage(myEndTurnMessage);
        //nächster Spieler aufrufen
    }
}
