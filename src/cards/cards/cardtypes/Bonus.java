package cards.cards.cardtypes;


import cards.AbstractCard;
import cards.TuttoRequired;

public class Bonus extends AbstractCard {
    public Bonus(int points){
        assert points>0;

        name="Bonus " + points;
        description = String.format("If you accomplish a 'Tutto' you get %2d in addition to the points you have rolled.\n " +
                "If you stop and have not accomplished a 'Tutto', you score only the bonus without getting the " +
                "bonus.", points);
        bonusPoints=points;
        requiredForPoints=TuttoRequired.Zero;
        requiredForBonus= TuttoRequired.One;
    }
}

