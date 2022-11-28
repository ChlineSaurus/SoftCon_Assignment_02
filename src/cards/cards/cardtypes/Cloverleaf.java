package cards.cards.cardtypes;


import Enums.GameConstants;
import cards.AbstractCard;
import cards.TuttoRequired;

public class Cloverleaf extends AbstractCard {


    public Cloverleaf(){
        diceTower.setDiceTowerNonStraight();
        //50000 are the most points the game can to
        bonusPoints= GameConstants.maxAllowedPoints.definedConstant;
        name="clover";
        requiredForPoints= TuttoRequired.Two;
        requiredForBonus=TuttoRequired.Two;
    }
}
