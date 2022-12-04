package cards;

import cards.cards.cardtypes.Fireworks;
import dice.Dice;
import exceptions.IllegalUserInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FireworkTest {
    Fireworks fireworks = new Fireworks();

    @Test
    public void ExceptionThrown() throws Exception {
        Exception e = Assertions.assertThrows(IllegalUserInputException.class, () -> {
            List<Dice> nuller = null;
            fireworks.userTriesToEndTurn();
        });
    }

    @Test
    public void hasToContinue() throws Exception {
        Assertions.assertTrue(fireworks.haveToContinueRolling());
    }
}
