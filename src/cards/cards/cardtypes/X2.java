package cards.cards.cardtypes;


import cards.AbstractCard;
import cards.TuttoRequired;

public class X2 extends AbstractCard {
    public X2(){
        name = "Double";
        bonusPoints = 2000; //provisorisch
        requiredForPoints = TuttoRequired.Zero;
        requiredForBonus = TuttoRequired.One;
    }
}
