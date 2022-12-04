package dice;

import dice.pointCalculator.PointCalculator;
import dice.pointCalculator.PointsCalculatorStandard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CalucaltePointsStandardTest {
    diceSelectionValidatorFireworkTest diceSelectionValidatorFireworkTest1=new diceSelectionValidatorFireworkTest();

    @Test
    public void threeOnes(){
        Integer []array={1,1,1,5};
        List<Dice> dices=diceSelectionValidatorFireworkTest1.diceListSetUp(array);
        PointCalculator calucaltePointsStandard=new PointsCalculatorStandard();
        Assertions.assertEquals(1050,calucaltePointsStandard.calculatePoints(dices));

    }

}
