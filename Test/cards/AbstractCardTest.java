package cards;

import cards.cards.cardInterfaces.bonusSystemInterface.PlusPoints;
import cards.cards.cardInterfaces.bonusSystemInterface.TimesX2Points;
import cards.cards.cardtypes.Bonus;
import cards.cards.cardtypes.Fireworks;
import exceptions.IllegalUserInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AbstractCardTest {
    Fireworks fireworks = new Fireworks();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;




    @Test
    public void setBonusSystemStandard() {
        PlusPoints bonusSystem = new PlusPoints();

    }

    @Test
    public void setBonusSystemX2() {
        TimesX2Points bonusSystem = new TimesX2Points();

    }

    @Test
    public void isImmunity() {
        assertEquals( true, fireworks.isImmunity());
    }



    @Test
    void userTriesToEndTurn() {
        assertThrows(IllegalUserInputException.class,
                () -> {
                    fireworks.userTriesToEndTurn();
                });
    }



    @Test
    void getDeductPoints() {
        assertEquals(fireworks.getDeductPoints(),0);
    }

    @Test
    void getName() {
        assertEquals("Fireworks", fireworks.getName());
    }

    @Test
    void getDescription() {
        assertEquals("""
                You have to keep throwing the dice until you roll a null. After each roll, you need to keep
                all valid single dice and triplets. If you accomplish a 'Tutto' you have to continue without revealing
                revealing a new card. Your turn ends only when you roll a null. However, you score all points you have
                rolled so far.
                
                """ +  "\u001B[35m" + "Please make sure to take ALL valid dice at once, otherways the game won't allow it." + "\u001B[0m"
                , fireworks.getDescription());
    }

    @Test
    void isEndTurn() {
        Assertions.assertFalse((fireworks.isEndTurn()));
    }

    @Test
    void notYetUsedDefaultSetting() throws Exception{
        AbstractCard aCard = new Bonus(800);
        Field f = aCard.getClass().getSuperclass().getDeclaredField("requiredForBonus");
        f.setAccessible(true);
        f.set(aCard, TuttoRequired.Two);
        Assertions.assertEquals(60, aCard.tuttoAchieved(60));
    }
}