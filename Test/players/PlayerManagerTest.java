package players;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PlayerManagerTest {
    Player player1 = new Player("Harry");
    Player player2 = new Player("Hermine");
    Player player3 = new Player("Ron");
    ArrayList<Player> players=createPlayerArrayList(player1, player2, player3);
    PlayerManager playerManager = PlayerManager.getInstance(players,3000);


    public ArrayList<Player> createPlayerArrayList(Player player1, Player player2, Player player3) {
        ArrayList<Player> players=new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        return players;
    }

    public void cleanUpSingelton() throws NoSuchFieldException, IllegalAccessException{
        for(Player aPlayer: players) {
            Field f = aPlayer.getClass().getDeclaredField("score");
            f.setAccessible(true);
            f.set(aPlayer, 0);
        }
        Field f3 = playerManager.getClass().getDeclaredField("players");
        f3.setAccessible(true);
        f3.set(playerManager, players);
        Field f1 = playerManager.getClass().getDeclaredField("currentPlayer");
        f1.setAccessible(true);
        f1.set(playerManager, player1);
        Field f2 = playerManager.getClass().getDeclaredField("currentPlayerIndex");
        f2.setAccessible(true);
        f2.set(playerManager, 0);



    }
    @Test
    public void singeltonTest () throws Exception {
        cleanUpSingelton();
        PlayerManager playerManager = PlayerManager.getInstance();
        PlayerManager clone=PlayerManager.getInstance();
        Assertions.assertEquals(playerManager,clone);
        PlayerManager clone2 = PlayerManager.getInstance(players, 9000);
        Assertions.assertEquals(playerManager,clone2);
    }

    @Test
    public void deductionPointsNormal() throws Exception{
        cleanUpSingelton();
        PlayerManager playerManager =PlayerManager.getInstance();
        player1.updateScore(500);
        player2.updateScore(2000);
        playerManager.deductLeadingPlayersPoints(1000);
        Assertions.assertEquals(500, player1.getScore());
        Assertions.assertEquals(1000, player2.getScore());
        Assertions.assertEquals(0, player3.getScore());
    }
    @Test
    public void deductionPointsSelfLeadingPlayer() throws Exception{
        cleanUpSingelton();
        PlayerManager playerManager =PlayerManager.getInstance();
        player1.updateScore(100);
        playerManager.deductLeadingPlayersPoints(1000);
        int decutionCounter=0;
        for (Player player:players){
            if (player.getScore()==-1000){
                decutionCounter++;
            }
        }
        Assertions.assertEquals(100, player1.getScore());
        Assertions.assertEquals(0,decutionCounter);
    }

    @Test
    public void deductionPointsTwoLeadingPlayer() throws Exception{
        cleanUpSingelton();
        PlayerManager playerManager =PlayerManager.getInstance();
        player1.updateScore(-100);
        playerManager.deductLeadingPlayersPoints(1000);
        Assertions.assertEquals(-100,player1.getScore());
        Assertions.assertEquals(-1000,player2.getScore());
        Assertions.assertEquals(-1000,player3.getScore());
    }

    @Test
    public void currentPlayerName() throws Exception{
        cleanUpSingelton();
        PlayerManager playerManager = PlayerManager.getInstance();
        Assertions.assertEquals("Harry", playerManager.currentPlayerName());
        playerManager.nextPlayersTurn(100);
        Assertions.assertEquals("Hermine", playerManager.currentPlayerName());
    }

    @Test
    public void displayFunctions() throws Exception{
        cleanUpSingelton();
        PlayerManager playerManager = PlayerManager.getInstance();
        player1.updateScore(100);
        player2.updateScore(500);
        List<String> playersName = playerManager.getPlayersName();
        List<Integer> playersScore = playerManager.getPlayersScore();
        Assertions.assertEquals("Harry", playersName.get(0));
        Assertions.assertEquals("Hermine", playersName.get(1));
        Assertions.assertEquals("Ron", playersName.get(2));
        Assertions.assertEquals(100, playersScore.get(0));
        Assertions.assertEquals(500, playersScore.get(1));
        Assertions.assertEquals(0, playersScore.get(2));
    }
}
