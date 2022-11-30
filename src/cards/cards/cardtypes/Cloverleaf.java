package cards.cards.cardtypes;


import Enums.GameConstants;
import cards.AbstractCard;
import cards.TuttoRequired;

public class Cloverleaf extends AbstractCard {


    public Cloverleaf(){
        //50000 are the most points the game can to
        bonusPoints= GameConstants.maxAllowedPoints.definedConstant;
        name="clover";
        description="";
        requiredForPoints= TuttoRequired.Two;
        requiredForBonus=TuttoRequired.Two;
    }

    @Override
    public boolean haveToContinueRolling(){
        return true;
    }
}
