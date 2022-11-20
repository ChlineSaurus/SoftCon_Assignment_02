package testing.dice;


import dice.Dice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class DiceTest {

    Dice dice=new Dice();

    @Test
    public void testRollGet (){
        int faceValue=dice.roll();
        int getFaceValue= dice.getFaceValue();
        Assertions.assertEquals(faceValue, getFaceValue);
    }
    @Test
    public void getValue(){
        int faceValue=dice.getFaceValue();
        Assertions.assertNotEquals(faceValue,0);
    }

}
