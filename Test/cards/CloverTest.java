package cards;

import cards.cards.cardtypes.Cloverleaf;

import exceptions.IllegalUserInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class CloverTest {



    /*Field[] aDiceFields = aDice.getClass().getDeclaredFields();
    *             for (Field field : aDiceFields) {
                if (field.getName().equals("currentFaceValue")) {
                    field.setAccessible(true);
                    try {
                        field.set(aDice, DiceFace.getEnum(integer));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }*/

    public AbstractCard modifiedClover() throws Exception{
        AbstractCard clover=new Cloverleaf();
        Field [] cloverFields=clover.getClass().getDeclaredFields();
        boolean changes=false;
        for (Field field: cloverFields){
            if (field.getName().equals("requiredForBonus")){
                try{
                field.setAccessible(true);
                field.set(clover, TuttoRequired.Zero);
                changes=true;}
                catch (IllegalAccessException e){
                    throw new RuntimeException(e);
                }
            }
        }
        return clover;
    }


    @Test
    public void achievingTuttoTwice() throws Exception{
        AbstractCard clover=new Cloverleaf();
        Assertions.assertEquals(5000,clover.tuttoAchieved(5000));


    }
    @Test
    public void userTriesToEndTurn() throws IllegalUserInputException {
        AbstractCard clover=new Cloverleaf();
        boolean noError=true;
        try {
            clover.userTriesToEndTurn();
        }
        catch (IllegalUserInputException e){
            noError=false;
        }
        assert !noError;
    }

}
