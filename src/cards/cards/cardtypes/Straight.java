package cards.cards.cardtypes;


import cards.AbstractCard;
import cards.TuttoRequired;

public class Straight extends AbstractCard {
   public Straight(){
    diceTower.setDiceTowerStraight();
    bonusPoints=2000;
    name="Straight";
    requiredForPoints= TuttoRequired.One;
    requiredForBonus=TuttoRequired.One;

    }

}
