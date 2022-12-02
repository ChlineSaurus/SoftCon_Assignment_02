package dice;


import dice.pointCalculator.PointCalculator;
import dice.pointCalculator.PointCalculatorStraight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NotNullStraightTest {
    PointCalculator StraightValidater=new PointCalculatorStraight();

    public List<Dice> DiceListSetUp(Integer[] customDiceValueArray){
        List<Dice> diceList=new ArrayList<>();
        for (Integer integer : customDiceValueArray) {
            Dice aDice = new Dice();
            Field[] aDiceFields = aDice.getClass().getDeclaredFields();
            for (Field field : aDiceFields) {
                if (field.getName().equals("currentFaceValue")) {
                    field.setAccessible(true);
                    try {
                        field.set(aDice, DiceFace.getEnum(integer));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            diceList.add(aDice);

        }
        return diceList;
    }

    @Test
    public void testLegalRoll1(){
        Integer[] notTakenArray={2,2,2,4};
        Integer[] takenDiceArray={1,5};
        List<Dice> takenDice=DiceListSetUp(takenDiceArray);
        List<Dice> notTakenDice=DiceListSetUp(notTakenArray);
        Assertions.assertTrue(StraightValidater.notNullRoll(notTakenDice,takenDice));
    }
    @Test
    public void testLegalRoll2(){
        Integer[] notTakenArray={3,3,3};
        Integer[] takenDiceArray={1,2,5};
        List<Dice> takenDice=DiceListSetUp(takenDiceArray);
        List<Dice> notTakenDice=DiceListSetUp(notTakenArray);
        Assertions.assertTrue(StraightValidater.notNullRoll(notTakenDice,takenDice));
    }
    @Test
    public void testIllegalRoll1(){
        Integer[] notTakenArray={3,3,2};
        Integer[] takenDiceArray={3,2,5};
        List<Dice> takenDice=DiceListSetUp(takenDiceArray);
        List<Dice> notTakenDice=DiceListSetUp(notTakenArray);
        Assertions.assertFalse(StraightValidater.notNullRoll(notTakenDice,takenDice));
    }
}