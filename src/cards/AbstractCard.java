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
    public boolean EndTurn;
    protected boolean KeepAllValidDice;
    protected boolean Immunity;
    protected boolean EndGame;

    private DiceTower dices;
    private BonusSystem TutoBonus;
    public AbstractCard(String name,int bonusPoints, int TuttorequiredForPoints, int TuttoRequiredForBonus){

    }
    public



    private TurnState turnState;


    public int addBonusPoints(){return 0;}


    public TurnState getTurnState() {
        return turnState;
    }
    private boolean checkBonusCondition(){
        return dices.madeTutto();
    }



    //public final boolean skipTurn;
    // needs to be added to Constructor



}



