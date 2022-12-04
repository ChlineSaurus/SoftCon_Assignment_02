package dice;

import dice.diceSelectionValidator.DiceSelectionValidatorFirework;
import dice.diceSelectionValidator.DiceSelectionValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class diceSelectionValidatorFireworkTest {
    DiceSelectionValidator mustSelectAllValidDice=new DiceSelectionValidatorFirework();

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
    public void testInvalidDices(){
        Integer [] chosenDice={1,1};
        Integer [] rolledDice={1,1,5,2};
        Integer [] takenDice={5,1};
        List<Dice> chosenDiceToKeep=diceListSetUp(chosenDice);
        List<Dice> rolledDices=diceListSetUp(rolledDice);
        List<Dice> takenDices=diceListSetUp(takenDice);
        Assertions.assertFalse(mustSelectAllValidDice.isUserSelectionValid(chosenDiceToKeep,rolledDices,takenDices));
    }
    @Test
    public void testTutto(){
        Integer[] chosenDiceArray={6,1,5,6,5,6};
        Integer [] rolledDiceArray={1,5,5,6,6,6};
        Integer [] takenDiceArray;
        List<Dice> chosenDice=diceListSetUp(chosenDiceArray);
        List<Dice> rolledDices=diceListSetUp(rolledDiceArray);
        List<Dice> takenDices=new ArrayList<Dice>();
        Assertions.assertTrue(mustSelectAllValidDice.isUserSelectionValid(chosenDice,rolledDices,takenDices));
    }
    @Test
    public void testValidDices(){
        Integer [] chosenDice={2,2,2};
        Integer [] rolledDice={2,2,2,2};
        Integer [] takenDice={5,1};
        List<Dice> chosenDiceToKeep=diceListSetUp(chosenDice);
        List<Dice> rolledDices=diceListSetUp(rolledDice);
        List<Dice> takenDices=diceListSetUp(takenDice);
        Assertions.assertTrue(mustSelectAllValidDice.isUserSelectionValid(chosenDiceToKeep,rolledDices,takenDices));
    }
    @Test
    public void testSingleValidDices(){
        Integer [] chosenDice={1};
        Integer [] rolledDice={6,6,3,4,2,1};
        Integer [] takenDice={0};
        List<Dice> chosenDiceToKeep=diceListSetUp(chosenDice);
        List<Dice> rolledDices=diceListSetUp(rolledDice);
        List<Dice> takenDices=diceListSetUp(takenDice);
        boolean temp=mustSelectAllValidDice.isUserSelectionValid(chosenDiceToKeep,rolledDices,takenDices);
        Assertions.assertTrue(mustSelectAllValidDice.isUserSelectionValid(chosenDiceToKeep,rolledDices,takenDices));
    }
}
