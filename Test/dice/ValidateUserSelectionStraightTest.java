package dice;

import dice.userDiceSelectionValidation.ValidUserSelectionStraight;
import dice.userDiceSelectionValidation.ValidateUserSelectedDice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ValidateUserSelectionStraightTest {
    ValidateUserSelectedDice validateUserSelectedDice=new ValidUserSelectionStraight();
    public List<Dice> diceListSetUp(Integer[] customDiceValueArray){
        List<Dice> diceList=new ArrayList<Dice>();
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
    public void testValidDices(){
        Integer [] chosenDice={1};
        Integer [] rolledDice={1,5,2};
        Integer [] takenDice={5,2,3};
        List<Dice> chosenDiceToKeep=diceListSetUp(chosenDice);
        List<Dice> rolledDices=diceListSetUp(rolledDice);
        List<Dice> takenDices=diceListSetUp(takenDice);
        Assertions.assertTrue(validateUserSelectedDice.isUserSelectionValid(chosenDiceToKeep,rolledDices,takenDices));
    }
    @Test
    public void testInValidDices(){
        Integer [] chosenDice={1,2};
        Integer [] rolledDice={1,1,5,2};
        Integer [] takenDice={5,1};
        List<Dice> chosenDiceToKeep=diceListSetUp(chosenDice);
        List<Dice> rolledDices=diceListSetUp(rolledDice);
        List<Dice> takenDices=diceListSetUp(takenDice);
        Assertions.assertFalse(validateUserSelectedDice.isUserSelectionValid(chosenDiceToKeep,rolledDices,takenDices));

    }
}