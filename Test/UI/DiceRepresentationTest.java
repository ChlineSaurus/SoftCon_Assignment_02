package UI;

import dice.DiceFace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DiceRepresentationTest {

    @Test
    public void testRepresent6(){
        String expected="""
            +-------+
            | o   o |
            | o   o |
            | o   o |
            +-------+""";
        String actual= DiceFace.Six.represent();
        Assertions.assertEquals(actual,expected);
    }
}
