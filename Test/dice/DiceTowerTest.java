package dice;

import exceptions.IllegalUserInputExeption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DiceTowerTest {
    DiceTower diceTower=new DiceTower();
    public ArrayList<Dice> DiceListSetUp(Integer[] customDiceValueArray){

        ArrayList<Dice> diceList=new ArrayList<Dice>();
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
    public void removeDiceTest(){
        diceTower.setDiceTowerNonStraight();
        Integer [] array1={3,3,3};
        List<Dice> customdice1=DiceListSetUp(array1);
        Integer [] array2={1,2,3};
        List<Dice> customdice2=DiceListSetUp(array2);

        diceTower.setDiceTowerNonStraight();
        diceTower.rollNotTakenDices();
        Field[] diceTowerFields = diceTower.getClass().getDeclaredFields();
        for (Field field : diceTowerFields) {
            if (field.getName().equals("notTakenDices")) {
                field.setAccessible(true);
                try{field.set("notTakenDices",customdice1);}
                catch (IllegalAccessException e){
                    throw new RuntimeException(e);
                }

            }
            if (field.getName().equals("TakenDices")) {
                field.setAccessible(true);
                try{field.set("TakenDices",customdice2);}
                catch (IllegalAccessException e){
                    throw new RuntimeException(e);
                }

            }



        }
        ArrayList<DiceFace> chosenDiceToRemove=new ArrayList<>();
        chosenDiceToRemove.add(DiceFace.One);
        try{
        Assertions.assertEquals(100,diceTower.removeDice(chosenDiceToRemove));}
        catch (IllegalUserInputExeption e){
            throw new RuntimeException(e);
        }

    }
}
