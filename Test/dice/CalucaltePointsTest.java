package dice;

import dice.pointCalculator.PointCalculator;
import dice.pointCalculator.PointCalculatorNoPointsForRoll;
import dice.pointCalculator.PointsCalculatorStandard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CalucaltePointsTest {
    diceSelectionValidatorFireworkTest diceSelectionValidatorFireworkTest1=new diceSelectionValidatorFireworkTest();

    @Test
    public void threeOnes(){
        Integer []array={1,1,1,5};
        List<Dice> dices=diceSelectionValidatorFireworkTest1.diceListSetUp(array);
        PointCalculator calucaltePointsStandard=new PointsCalculatorStandard();
        Assertions.assertEquals(1050,calucaltePointsStandard.calculatePoints(dices));

    }

    @Test
    public void noPointDie(){
        Integer []array={1,1,1,5,3};
        List<Dice> dices=diceSelectionValidatorFireworkTest1.diceListSetUp(array);
        PointCalculator calucaltePointsStandard=new PointsCalculatorStandard();
        Assertions.assertEquals(1050,calucaltePointsStandard.calculatePoints(dices));
    }
    @Test
    public void pointValiderWithNoPoints(){
        PointCalculator noPoint = new PointCalculatorNoPointsForRoll();
        Integer []array={1,1,1,5};
        List<Dice> dices=diceSelectionValidatorFireworkTest1.diceListSetUp(array);
        Assertions.assertEquals(0,noPoint.calculatePoints(dices));
    }

}
