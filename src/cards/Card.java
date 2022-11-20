package cards;

import Turn.TurnState;
import cards.cards.TutoCondition;

public class Card {

    protected String name;
    protected int points;
    protected TutoCondition valid;

    private TurnState turnState;

    public TurnState getTurnState() {
        return turnState;
    }
    //public final boolean skipTurn;
    // needs to be added to Constructer



}



