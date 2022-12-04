package cards.cardTypes;

import cards.AbstractCard;
import cards.TuttoRequired;
import cards.cards.cardtypes.Cloverleaf;

import exceptions.IllegalUserInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class CloverTest {

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
    public void haveToContinue() throws Exception{
        AbstractCard clover=new Cloverleaf();
        Assertions.assertEquals(5000,clover.tuttoAchieved(5000));
        Assertions.assertTrue(clover.haveToContinueRolling());
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
