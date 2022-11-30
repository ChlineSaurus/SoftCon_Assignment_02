package cards.cards.cardtypes;


import cards.AbstractCard;
import cards.TuttoRequired;

public class PlusMinus extends AbstractCard {

    public PlusMinus() {

        name="PlusMinus";
        description="You only can achieve if you roll a tutto. You'll recieve 1000 points" +
                " and 1000 points are going to be deducted from the leader. ";
        bonusPoints=1000;
        deductionPoints=1000;
        requiredForPoints= TuttoRequired.One;
        requiredForBonus=TuttoRequired.One;
    }

    @Override
    public int tuttoAchieved(int currentPoints) {
        super.tuttoAchieved(currentPoints);
        return 1000;
    }
}
