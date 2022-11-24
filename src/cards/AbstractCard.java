package cards;

import Turn.State.TurnState;
import cards.cards.TuttoCondition;
import cards.cards.cardInterfaces.bonusSystemInterface.BonusSystem;
import dice.DiceTower;

public abstract class AbstractCard {

    protected String name;
    protected int points;
    protected TuttoCondition valid;
    protected int TuttoRequiredForPoints;
    protected boolean EndTurn;
    protected boolean KeepAllValidDice;
    protected boolean Immunity;
    protected boolean EndGame;

    private DiceTower dices;
    private BonusSystem tutoBonus;




    private TurnState turnState;


    public TurnState getTurnState() {
        return turnState;
    }
    private boolean checkBonusCondition(){
        return dices.madeTutto();
    }



    //public final boolean skipTurn;
    // needs to be added to Constructor



}



