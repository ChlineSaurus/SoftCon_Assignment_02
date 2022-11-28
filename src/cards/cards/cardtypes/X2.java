package cards.cards.cardtypes;


import cards.AbstractCard;
import cards.TuttoRequired;

public class X2 extends AbstractCard {


    public X2(){
        diceTower.setDiceTowerNonStraight();
        name="X2";
        setBonusSystemX2();
        requiredForPoints= TuttoRequired.Zero;
        requiredForBonus=TuttoRequired.One;
        bonusPoints=0;
    }
}
