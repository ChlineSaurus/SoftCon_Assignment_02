package cards.cards.cardtypes;


import cards.AbstractCard;
import cards.TuttoRequired;

public class Fireworks extends AbstractCard {


    public Fireworks(){
        diceTower.setDiceTowerFirework();
        immunity=true;
        bonusPoints=0;
        name="Fireworks";
        requiredForPoints= TuttoRequired.Zero;
        requiredForBonus=TuttoRequired.Zero;


    }

}
