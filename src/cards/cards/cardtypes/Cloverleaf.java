package cards.cards.cardtypes;


import Enums.GameConstants;
import cards.AbstractCard;
import cards.TuttoRequired;
import players.PlayerManager;

import static java.lang.System.exit;

public class Cloverleaf extends AbstractCard {

    //schauen!!!
    public Cloverleaf(){
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
    public int tuttoAchieved(int currentPoints){
        if (!isPointConditionAchieved()){
            requiredForPoints=TuttoRequired.getEnum((requiredForPoints.integerValue)-1);
        }
        if (!isBonusConditionAchieved()){
            requiredForBonus=TuttoRequired.getEnum(requiredForBonus.integerValue-1);
        }
        if (isBonusConditionAchieved()) {
            PlayerManager playerManager=PlayerManager.getInstance();
            String winnerName=playerManager.getCurrentPlayersName();
            UI.Display.declareWinner(winnerName);
            exit (0);

        }
        return currentPoints;
    }

    @Override
    public boolean haveToContinueRolling(){
        return true;
    }
}
