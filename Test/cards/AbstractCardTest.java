package cards;

import cards.cards.cardInterfaces.bonusSystemInterface.PlusPoints;
import cards.cards.cardInterfaces.bonusSystemInterface.TimesX2Points;
import cards.cards.cardtypes.Fireworks;
import exceptions.IllegalUserInputExeption;
import org.junit.jupiter.api.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AbstractCardTest {
    Fireworks fireworks = new Fireworks();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeClass
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterClass
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }


    @Test
    public void setBonusSystemStandard() {
        PlusPoints bonusSystem = new PlusPoints();

    }

    @Test
    public void setBonusSystemX2() {
        TimesX2Points bonusSystem = new TimesX2Points();
        assertEquals(new TimesX2Points(), bonusSystem);
    }

    @Test
    public void isImmunity() {
        assertEquals( true, fireworks.immunity);
    }

    @Test
    public void tuttoAchieved() {
    }

    @Test
    void userTriesToEndTurn() {
        assertThrows(IllegalUserInputExeption.class,
                () -> {
                    fireworks.userTriesToEndTurn();
                });
    }

    @Test
    void haveToContinueRolling() {
    }

    @Test
    void injectStrategyToTower() {

    }

    @Test
    void getDeductPoints() {
    }

    @Test
    void getName() {
        assertEquals("Fireworks", fireworks.name);
    }

    @Test
    void getDescription() {
        assertEquals("""
                You have to keep throwing the dice until you roll a null. After each roll, you need to keep
                all valid single dice and triplets. If you accomplish a 'Tutto' you have to continue without revealing
                revealing a new card. Your turn ends only when you roll a null. However, you score all points you have
                rolled so far.
                """, fireworks.description);
    }

    @Test
    void isEndTurn() {
    }
}