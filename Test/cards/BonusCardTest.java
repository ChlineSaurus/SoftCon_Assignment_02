package cards;

import cards.cards.cardtypes.Bonus;
import exceptions.IllegalUserInputExeption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusCardTest {
    AbstractCard bonusCard=new Bonus(400);

    @Test
    public void tuttoAchieved(){
        Assertions.assertEquals(bonusCard.tuttoAchieved(0),400);
    }
    @Test
    public void userTriesToEndTurn() throws IllegalUserInputExeption {
        boolean noError=true;
        try {
            bonusCard.userTriesToEndTurn();
        }
        catch (IllegalUserInputExeption e){
            noError=false;
        }
        assert noError;
    }

}
