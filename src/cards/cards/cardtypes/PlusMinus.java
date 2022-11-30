package cards.cards.cardtypes;


import cards.AbstractCard;
import cards.TuttoRequired;

public class PlusMinus extends AbstractCard {




    public PlusMinus() {

        name="PlusMinus";
        bonusPoints=1000;
        deductPoints=1000;
        requiredForPoints= TuttoRequired.One;
        requiredForBonus=TuttoRequired.One;
    }
}
