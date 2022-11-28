package cards.cards.cardtypes;


import cards.AbstractCard;
import cards.TuttoRequired;

public class PlusMinus extends AbstractCard {

    int TuttoRequiredForPoints = 1;
    boolean EndTurn = false;
    boolean KeepAllValidDice = false;
    boolean Immunity = false;
    boolean EndGame = false;
    int TuttoRequiredForBonus = 1;


    public PlusMinus() {

        name="PlusMinus";
        diceTower.setDiceTowerNonStraight();
        bonusPoints=1000;
        deductPoints=1000;
        requiredForPoints= TuttoRequired.One;
        requiredForBonus=TuttoRequired.One;
    }
}
