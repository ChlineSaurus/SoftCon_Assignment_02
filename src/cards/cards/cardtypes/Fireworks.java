package cards.cards.cardtypes;


import cards.AbstractCard;

public class Fireworks extends AbstractCard {
    private final String name="Fireworks";

    public Fireworks(){
        diceTower.setDiceTowerFirework();
        immunity=true;
        bonusPoints=0;


    }

}
