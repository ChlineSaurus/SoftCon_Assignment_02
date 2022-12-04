package cards.cards.cardtypes;

import cards.AbstractCard;

public class Stop extends AbstractCard {

    public Stop(){
        name="Stop";
        description="Tough Luck! You have to end your turn, and your left neighbour has his turn.";
        this.endTurn=true;
    }
}
