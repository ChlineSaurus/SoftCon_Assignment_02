package cards.cards.cardtypes;


import Enums.GameConstants;
import cards.AbstractCard;
import cards.TuttoRequired;

public class Cloverleaf extends AbstractCard {


    public Cloverleaf(){
        //50000 are the most points the game can to
        bonusPoints= GameConstants.maxAllowedPoints.definedConstant;
        name="Cloverleaf";
        description= """
                You have to try to accomplish a 'Tutto' twice in a row on this turn and may not stop before you do so.
                If you roll a null, you don't score any points. But if you succeed, the game ends immediately, and you win
                - no matter whats the score""";
        requiredForPoints= TuttoRequired.Two;
        requiredForBonus=TuttoRequired.Two;
    }

    @Override
    public boolean haveToContinueRolling(){
        return true;
    }
}
