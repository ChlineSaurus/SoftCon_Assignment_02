package Turn.State;

import exceptions.IllegalUserInputExeption;
import players.Player;
import players.PlayerManager;

import java.io.IOException;
import java.util.ArrayList;

public class StartPlayerTurn implements TurnState {
    Turn aTurn;
    public StartPlayerTurn(Turn aTurn){
        this.aTurn = aTurn;
    }
    @Override
    public void next(Turn aTurn) throws IOException, IllegalUserInputExeption {
        ArrayList<Player> myPlayer = new ArrayList<Player>();
        Player max = new Player("max");
        Player mic = new Player("mic");
        myPlayer.add(max);
        myPlayer.add(mic);
        System.out.println("I am in StartPlayerTurn");
        PlayerManager myManager = new PlayerManager(myPlayer,3000);
        System.out.println("get Card");
        aTurn.turnCard = myManager.getCard();

        System.out.println(aTurn.turnCard.getName());
        if(aTurn.turnCard.getName().equals("Stop")){
            aTurn.score = 0;
            aTurn.setState(new EndTurn(aTurn));
        }

        aTurn.setState(new CurrentlyPlaying(aTurn));
    }

}
