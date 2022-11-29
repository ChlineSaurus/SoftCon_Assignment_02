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

        System.out.println("I am in StartPlayerTurn");
        PlayerManager currentPlayer = PlayerManager.getInstance();
        aTurn.turnCard = currentPlayer.getCard();
        aTurn.playerDice.newTurn();
        //aTurn.turnCard = PlayerManager.getInstance().getCard();
        System.out.println(aTurn.turnCard.getName());
        if(aTurn.turnCard.getName().equals("Stop"){
            aTurn.score = 0;
            aTurn.setState(new EndTurn(aTurn));
        }

        aTurn.setState(new CurrentlyPlaying(aTurn));
    }

}
