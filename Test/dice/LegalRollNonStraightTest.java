package dice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.List;

public class LegalRollNonStraightTest {
    LegalRoll straightValidater=new LegalRollNonStraight();


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
    public void legalRoll(){
        Integer[] throwndiceArray={1,5};
        Integer[] notThrownArray={2,2,2,4};
        List<Dice> thrownDice=DiceListSetUp(throwndiceArray);
        List<Dice> notThrownDice=DiceListSetUp(notThrownArray);
        Assertions.assertTrue(straightValidater.validateDice(thrownDice,notThrownDice));


    }
    @Test
    public void illegalRoll(){

    }

}
