package cards;

import cards.cards.cardInterfaces.bonusSystemInterface.BonusSystem;
import cards.cards.cardInterfaces.bonusSystemInterface.PlusPoints;
import cards.cards.cardInterfaces.bonusSystemInterface.TimesX2Points;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusPointsTest {
    BonusSystem plusPoints=new PlusPoints();
    BonusSystem x2Points=new TimesX2Points();

    @Test
    public void addPlusPoints(){
        Assertions.assertEquals(1500,plusPoints.bonusPoints(500,1000));
    }
    @Test
    public void add2xPoints(){
        Assertions.assertEquals(2000,x2Points.bonusPoints(0,1000));
    }
}
