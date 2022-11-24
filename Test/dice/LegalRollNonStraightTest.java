package dice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.List;

public class LegalRollNonStraightTest {
    LegalRoll NonStraightValidater=new LegalRollNonStraight();


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
    public void testTemplate(Integer[] takenDiceArray,Integer notTakenArray){
        //Idee wäre diesen Junk zu löschen
    }

    @Test
    public void testLegalRoll1(){
        Integer[] takenDiceArray={1,5};
        Integer[] notTakenArray={2,2,2,4};
        List<Dice> takenDice=DiceListSetUp(takenDiceArray);
        List<Dice> notTakenDice=DiceListSetUp(notTakenArray);
        Assertions.assertTrue(NonStraightValidater.validateDice(takenDice,notTakenDice));
    }

    @Test
    public void testLegalRoll2(){
        Integer[] takenArray={1};
        Integer[] notTakenArray={2,2,3,4,1};
        List<Dice> takenDice=DiceListSetUp(takenArray);
        List<Dice> notTakenDice=DiceListSetUp(notTakenArray);
        Assertions.assertTrue(NonStraightValidater.validateDice(takenDice,notTakenDice));
    }
    @Test
    public void TestIllegalRoll1(){

        Integer[] takenDiceArray={1,5,1,1};
        Integer[] notTakenArray={2,3};
        List<Dice> takenDice=DiceListSetUp(takenDiceArray);
        List<Dice> notTakenDice=DiceListSetUp(notTakenArray);
        Assertions.assertFalse(NonStraightValidater.validateDice(notTakenDice,takenDice));

    }
    @Test
    public void TestIllegalRoll2(){

        Integer[] takenDiceArray={1,5,1};
        Integer[] notTakenArray={2,2,4};
        List<Dice> takenDice=DiceListSetUp(takenDiceArray);
        List<Dice> notTakenDice=DiceListSetUp(notTakenArray);
        Assertions.assertFalse(NonStraightValidater.validateDice(notTakenDice,takenDice));

    }


}