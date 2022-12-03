package players;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    Player aPlayer=new Player("Harry");

    @Test
    public void doesUpdateScoreCorrectlyTest(){
        aPlayer.updateScore(50);
        Assertions.assertEquals(50,aPlayer.getScore());
        aPlayer.updateScore(-500);
        Assertions.assertEquals(-450,aPlayer.getScore());
    }
    @Test
    public void CompareToTestSame(){
        Player player2=new Player("Harry");
        Assertions.assertEquals(0,aPlayer.compareTo(player2));
    }
    @Test
    public void CompareToTestHigher(){
        Player player2=new Player("Albus");
        Assertions.assertTrue(0 < aPlayer.compareTo(player2));
    }
    @Test
    public void CompareToTestLower(){
        Player player2=new Player("Hermine");
        Assertions.assertTrue(0 > aPlayer.compareTo(player2));
    }
    @Test
    public void name(){
        Assertions.assertEquals("Harry", aPlayer.name);
    }
}
