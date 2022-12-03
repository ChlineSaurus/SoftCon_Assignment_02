package turn;

import org.junit.jupiter.api.Test;
import players.Player;
import players.PlayerManager;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class newTurn {

        Player player1 = new Player("Hermine");
        Player player2 = new Player("Harry");
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
            Field f1 = playerManager.getClass().getDeclaredField("currentPlayer");
            f1.setAccessible(true);
            f1.set(playerManager, player2);
            Field f2 = playerManager.getClass().getDeclaredField("currentPlayerIndex");
            f2.setAccessible(true);
            f2.set(playerManager, 0);

        }

        @Test
        public void newTurnTest(){

        }

}
