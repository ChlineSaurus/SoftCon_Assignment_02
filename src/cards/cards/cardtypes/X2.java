package cards.cards.cardtypes;


import cards.AbstractCard;
import cards.TuttoRequired;

public class X2 extends AbstractCard {
    public X2(){
        name = "Double";
        description="";
        bonusPoints = 2000;
        requiredForPoints = TuttoRequired.Zero;
        requiredForBonus = TuttoRequired.One;
    }
}
