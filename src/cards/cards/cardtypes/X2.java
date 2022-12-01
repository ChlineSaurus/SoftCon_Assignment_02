package cards.cards.cardtypes;


import cards.AbstractCard;
import cards.TuttoRequired;

public class X2 extends AbstractCard {
    public X2(){
        setBonusSystemX2();
        name = "Double";
        description="If you accomplish a 'Tutto', all points you have rolled so far on this turn are doubled. If you \n" +
                "stop and have not accomplished a 'Tutto', you score only the points rolled";
        bonusPoints = 2000;
        requiredForPoints = TuttoRequired.Zero;
        requiredForBonus = TuttoRequired.One;
    }
}
