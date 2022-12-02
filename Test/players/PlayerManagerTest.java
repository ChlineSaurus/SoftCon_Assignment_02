package players;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PlayerManagerTest {

    ArrayList<Player> players=createPlayerArrayList();
    Player testPlayer=new Player("testPlayer");



    public ArrayList<Player> createPlayerArrayList() {
        ArrayList<Player> players=new ArrayList<>();
        players.add(new Player("bob"));
        players.add(new Player("billy"));

        return players;
    }

    @Test
    public void singeltonTest () throws Exception {
        PlayerManager playerManager =PlayerManager.getInstance(players,6000);
        PlayerManager clone=PlayerManager.getInstance();
        Assertions.assertEquals(playerManager,clone);

    }
    @Test
    public void deductionPointsTest() throws Exception{
        PlayerManager playerManager =PlayerManager.getInstance(players,6000);
        playerManager.deductLeadingPlayersPoints(1000);
        int decutionCounter=0;
        for (Player player:players){

            if (player.getScore()==-1000){
                System.out.println(player.name);
                decutionCounter++;
            }
        }
        Assertions.assertEquals(1,decutionCounter);

        //bob has tutto and a +/- card
        //1000 points should be deducted from testplayer.
        //Assertions.assertEquals(,1000);


    }
}
