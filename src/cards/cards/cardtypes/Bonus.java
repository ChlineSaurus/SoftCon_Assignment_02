package cards.cards.cardtypes;


import cards.AbstractCard;
import cards.TuttoRequired;

public class Bonus extends AbstractCard {
    public Bonus(int points){
        assert points>0;

        name="Bonus "+points;
        description ="bla bla";
        bonusPoints=points;
        requiredForPoints=TuttoRequired.Zero;
        requiredForBonus= TuttoRequired.One;
    }
}

