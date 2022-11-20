package testing.UI;

public class DiceRepresentationTest {

    @Test
    public void testRepresent6(){
        String expected="""
            +-------+
            | o   o |
            | o   o |
            | o   o |
            +-------+""";
        String actual=DiceRepresentation.represent(6);
        Assertions.assertEquals(actual,expected);
    }
}
