package cards.cards.cardtypes;


import cards.AbstractCard;

public class Stop extends AbstractCard {

    public Stop(){
        super();
        this.endTurn=true;
        name="Stop";
    }
}
