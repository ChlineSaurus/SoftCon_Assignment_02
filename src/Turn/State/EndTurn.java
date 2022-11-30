package Turn.State;

import UI.Display;
import Turn.Turn;
import exceptions.IllegalUserInputExeption;
import players.PlayerManager;

import java.io.IOException;

public class EndTurn implements TurnState{
    Turn aTurn;

    public EndTurn(Turn aTurn){this.aTurn = aTurn;}
    @Override
    public void next() throws IllegalUserInputExeption {

        if(aTurn.turnCard.getName().equals("Fireworks")/*muss noch eine Expression hin, wie kein Null Wurf*/){
            aTurn.setCurrentState(new CurrentlyPlaying(aTurn));
        }

        deductPoints(aTurn.pointsToDeduct);
        nextPlayer(aTurn.score);

        String myEndTurnMessage = "Your turn is over, now it is next players turn.";

        Display.displayMessage(myEndTurnMessage);
        aTurn.newTurn();
    }
    public void deductPoints(int pointsToDeduct) {
        PlayerManager playerManager=PlayerManager.getInstance();
        playerManager.deductLeadingPlayersPoints(pointsToDeduct);
    }
    private void nextPlayer(int pointsToAdd) throws IOException, IllegalUserInputExeption {

    }
}