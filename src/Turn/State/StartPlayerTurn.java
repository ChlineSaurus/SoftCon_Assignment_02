package Turn.State;

import exceptions.IllegalUserInputExeption;
import players.PlayerManager;

import java.io.IOException;

public class StartPlayerTurn implements TurnState {
    Turn aTurn;
    public StartPlayerTurn(Turn aTurn){
        this.aTurn = aTurn;
    }
    @Override
    public void next(Turn aTurn) throws IOException, IllegalUserInputExeption {

        System.out.println("get Card");
        aTurn.turnCard = PlayerManager.getInstance().getCard();
        //aTurn.turnCard = PlayerManager.getInstance().getCard();
        System.out.println(aTurn.turnCard.getName());
        //if(aTurn.turnCard.equals() StopKarte:
        //set Score = 0
        //aTurn.setSate(new EndTurn(aTurn));
        aTurn.setState(new CurrentlyPlaying(aTurn));
    }

}
