package testing.dice;


import dice.Dice;
import dice.DiceFace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class DiceTest {

    Dice dice=new Dice();

    @Test
    public void testRollGet (){
        DiceFace faceValue=dice.roll();
        DiceFace getFaceValue= dice.getFaceValue();
        Assertions.assertEquals(faceValue, getFaceValue);
    }
    @Test
    public void getValue(){
        DiceFace faceValue = dice.getFaceValue();
        Assertions.assertNotEquals(faceValue,0);
    }

}
