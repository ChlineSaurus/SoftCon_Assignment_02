package dice;

import dice.diceSelectionValidator.DiceSelectionValidatorFirework;
import dice.diceSelectionValidator.DiceSelectionValidatorStandard;
import dice.notNullRoll.NotNullRollStandard;
import dice.notNullRoll.NotNullRollStraight;
import dice.pointCalculator.PointsCalculatorStandard;
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


    @Test()
    public void removeDiceTestInvalid() throws Exception{

        diceTower.setStrategy(new PointsCalculatorStandard(),new DiceSelectionValidatorStandard(),new NotNullRollStandard());
        Integer [] array1={3,3,3};
        List<Dice> customdice1=DiceListSetUp(array1);
        Integer [] array2={1,2,3};
        List<Dice> customdice2=DiceListSetUp(array2);
        ArrayList<DiceFace> diceFaces=new ArrayList<>();
        diceFaces.add(DiceFace.Three);


        diceTower.rollNotTakenDices();
        Field f = diceTower.getClass().getDeclaredField("notTakenDices");
        f.setAccessible(true);
        f.set(diceTower,customdice2);
        Field f2= diceTower.getClass().getDeclaredField("takenDices");
        f2.setAccessible(true);
        f2.set(diceTower,customdice1);
        boolean thrown=false;
        try{diceTower.removeDice(diceFaces);}
        catch (IllegalUserInputExeption e){
            thrown=true;
        }
        assert thrown;
    }
    @Test
    public void removeDiceTestValid() throws Exception{
        diceTower.setStrategy(new PointsCalculatorStandard(),new DiceSelectionValidatorStandard(),new NotNullRollStandard());
        Integer [] array1={3,3,3};
        List<Dice> customdice1=DiceListSetUp(array1);
        Integer [] array2={1,2,3};
        List<Dice> customdice2=DiceListSetUp(array2);
        ArrayList<DiceFace> diceFaces=new ArrayList<>();
        diceFaces.add(DiceFace.One);


        diceTower.rollNotTakenDices();
        Field f = diceTower.getClass().getDeclaredField("notTakenDices");
        f.setAccessible(true);
        f.set(diceTower,customdice2);
        Field f2= diceTower.getClass().getDeclaredField("takenDices");
        f2.setAccessible(true);
        f2.set(diceTower,customdice1);
        boolean thrown=false;
        Assertions.assertEquals(100,diceTower.removeDice(diceFaces));
    }
        @Test
        public void diceListToValueTest() throws Exception{

            diceTower.setStrategy(new PointsCalculatorStandard(),new DiceSelectionValidatorFirework(),new NotNullRollStandard());
            Integer [] diceArray={2,4,6};
            ArrayList<Dice> expected=DiceListSetUp(diceArray);
            ArrayList<DiceFace> diceFaces=new ArrayList<>();
            diceFaces.add(DiceFace.Two);
            diceFaces.add(DiceFace.Four);
            diceFaces.add(DiceFace.Six);
            int i=0;
            Field takenDiceField=diceTower.getClass().getDeclaredField("takenDices");
            takenDiceField.setAccessible(true);
            takenDiceField.set(diceTower,expected);
            ArrayList<DiceFace> actual=diceTower.showTakenDices();
            for (DiceFace diceFace: actual){
                assert diceFace.integerValue==diceFaces.get(i).integerValue;
                i++;
            }




        }
        @Test
        public void checklengthofTaken() throws Exception{
            diceTower.setStrategy(new PointsCalculatorStandard(),new DiceSelectionValidatorStandard(),new NotNullRollStandard());
            Integer [] array1={1,3,3};
            List<Dice> customdice1=DiceListSetUp(array1);
            Integer [] array2={3,3,3};
            List<Dice> customdice2=DiceListSetUp(array2);
            ArrayList<DiceFace> diceFaces=new ArrayList<>();
            diceFaces.add(DiceFace.Three);
            diceFaces.add(DiceFace.Three);
            diceFaces.add(DiceFace.Three);
            diceTower.rollNotTakenDices();
            Field f = diceTower.getClass().getDeclaredField("notTakenDices");
            f.setAccessible(true);
            f.set(diceTower,customdice2);
            Field f2= diceTower.getClass().getDeclaredField("takenDices");
            f2.setAccessible(true);
            f2.set(diceTower,customdice1);

            diceTower.removeDice(diceFaces);
            int actual=diceTower.showNotTakenDices().size()+diceTower.showTakenDices().size();

            Assertions.assertEquals(6,actual);
        }
        @Test
        public void TestnewTurn() throws Exception{
        diceTower.setStrategy(new PointsCalculatorStandard(), new DiceSelectionValidatorStandard(), new NotNullRollStraight());
        diceTower.newTurn();
        Field f=diceTower.getClass().getDeclaredField("takenDices");
        f.setAccessible(true);
        ArrayList<Dice> dices= (ArrayList<Dice>) f.get(diceTower);
        assert dices.size()==0;

        }
        @Test
        public void madeTutto() throws Exception{

        }


    }

