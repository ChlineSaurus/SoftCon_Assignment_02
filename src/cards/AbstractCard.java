package cards;

import Turn.State.TurnState;
import cards.cards.TuttoCondition;

public abstract class AbstractCard {

    protected String name;
    protected int points;
    protected TuttoCondition valid;
    protected int TuttoRequiredForPoints;
    protected boolean EndTurn;
    protected boolean KeepAllValidDice;
    protected boolean Immunity;
    protected boolean EndGame;
    protected int TuttoRequiredForBonus; //maybe combine with TuttoRequiredForPoints



    private TurnState turnState;

    public TurnState getTurnState() {
        return turnState;
    }
    //public final boolean skipTurn;
    // needs to be added to Constructor



}



