package cards;

import cards.cards.cardtypes.PlusMinus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlusMinusTest {
    AbstractCard plusMinus = new PlusMinus();

    @Test
    void haveToContinue() {
        Assertions.assertTrue(plusMinus.haveToContinueRolling());
    }

    @Test
    void haveTutto() {
        Assertions.assertEquals(1000, plusMinus.tuttoAchieved(0));
    }
}
