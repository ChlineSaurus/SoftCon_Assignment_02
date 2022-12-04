package cards.cardTypes;

import cards.AbstractCard;
import cards.cards.cardtypes.Bonus;
import exceptions.IllegalUserInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusCardTest {
    AbstractCard bonusCard=new Bonus(400);

    @Test
    public void tuttoAchieved(){
        Assertions.assertEquals(bonusCard.tuttoAchieved(0),400);
    }
    @Test
    public void userTriesToEndTurn() throws IllegalUserInputException {
        boolean noError=true;
        try {
            bonusCard.userTriesToEndTurn();
        }
        catch (IllegalUserInputException e){
            noError=false;
        }
        assert noError;
    }

}
