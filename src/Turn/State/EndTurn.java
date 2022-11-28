package Turn.State;

import UI.Display;

import exceptions.IllegalUserInputExeption;
import players.PlayerManager;

import java.io.IOException;

public class EndTurn implements TurnState{
    Turn aTurn;

    public EndTurn(Turn aTurn){this.aTurn = aTurn;}
    @Override
    public void next(Turn aTurn) throws IOException, IllegalUserInputExeption {

        if(aTurn.turnCard.getName().equals("Fireworks")/*muss noch eine Expression hin, wie kein Null Wurf*/){
            aTurn.setState(new CurrentlyPlaying(aTurn));
        }

        deductPoints(aTurn.pointsToDeduct);
        nextPlayer(aTurn.score);

        String myEndTurnMessage = "Your turn is over, now it is next players turn.";

        Display.displayMessage(myEndTurnMessage);


        //nächster Spieler aufrufen

    }
    public void deductPoints(int pointsToDeduct) {
        PlayerManager playerManager=PlayerManager.getInstance();
        playerManager.deductLeadingPlayersPoints(pointsToDeduct);
    }
    private void nextPlayer(int pointsToAdd){
        PlayerManager playerManager=PlayerManager.getInstance();
        playerManager.nextPlayersTurn(pointsToAdd);
    }

}
