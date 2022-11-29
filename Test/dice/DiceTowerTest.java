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
    public void removeDiceTest() throws Exception{
        diceTower.setDiceTowerNonStraight();
        Integer [] array1={3,3,3};
        List<Dice> customdice1=DiceListSetUp(array1);
        Integer [] array2={1,2,3};
        List<Dice> customdice2=DiceListSetUp(array2);
        ArrayList<DiceFace> diceFaces=new ArrayList<>();
        diceFaces.add(DiceFace.Three);

        diceTower.setDiceTowerNonStraight();
        diceTower.rollNotTakenDices();
        Field f = diceTower.getClass().getDeclaredField("notTakenDices");
        f.setAccessible(true);
        f.set(diceTower,customdice2);
        Field f2= diceTower.getClass().getDeclaredField("takenDices");
        f2.setAccessible(true);
        f2.set(diceTower,customdice1);

        Assertions.assertThrows(IllegalUserInputExeption,diceTower.removeDice(diceFaces));





        }


    }

