package players;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    Player aPlayer=new Player("testplayer");

    @Test
    public void doesUpdateScoreCorrectlyTest(){
        aPlayer.updateScore(50);
        Assertions.assertEquals(50,aPlayer.getScore());
    }
    @Test
    public void CompareToTest(){
        Player player2=new Player("testplayer");
        Assertions.assertEquals(0,aPlayer.compareTo(player2));
    }

}
