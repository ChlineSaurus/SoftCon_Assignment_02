package dice;


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
    public void testDiceAssertion() throws Exception{
        Assertions.assertThrows(AssertionError.class, () -> {
            dice.getFaceValue();
        });
    }
}
