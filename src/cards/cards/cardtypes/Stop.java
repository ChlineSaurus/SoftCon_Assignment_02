package cards.cards.cardtypes;

import cards.AbstractCard;

public class Stop extends AbstractCard {

    public Stop(){
        name="\u001B[31mStop"+"\u001B[0m";
        description="Tough Luck! You have to end your turn, and your left neighbour has his turn.";
        this.endTurn=true;
    }
}
