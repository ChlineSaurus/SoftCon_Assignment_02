package cards.cards.cardtypes;


import cards.AbstractCard;

public class Stop extends AbstractCard {
    private final String name="Stop";
    public Stop(){
        super();
        this.endTurn=true;
    }
}
