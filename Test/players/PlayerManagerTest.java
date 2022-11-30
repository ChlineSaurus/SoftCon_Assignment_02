package players;

import exceptions.IllegalUserInputExeption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

public class PlayerManagerTest {

    ArrayList<Player> players=createPlayerArrayList();
    Player testPlayer=new Player("testPlayer");



    public ArrayList<Player> createPlayerArrayList() {
        ArrayList<Player> players=new ArrayList<>();
        players.add(new Player("bob"));
        players.add(new Player("billy"));
        players.add(new Player("Sam"));

        return players;
    }

    @Test
    public void singeltonTest ()throws IOException, IllegalUserInputExeption {
        PlayerManager playerManager =PlayerManager.getInstance(players,6000);
        PlayerManager clone=PlayerManager.getInstance();
        Assertions.assertEquals(playerManager,clone);

    }
    @Test
    public void deductionPointsTest() throws IOException, IllegalUserInputExeption{
        PlayerManager playerManager =PlayerManager.getInstance(players,6000);
        playerManager.nextPlayersTurn(1000);
        playerManager.nextPlayersTurn(500);
        playerManager.nextPlayersTurn(300);

        playerManager.nextPlayersTurn(2000);//to testplayer
        playerManager.deductLeadingPlayersPoints(1000);//bob has tutto and a +/- card
        //1000 points should be deducted from testplayer.
        Assertions.assertEquals(testPlayer.getScore(),1000);


    }
}
