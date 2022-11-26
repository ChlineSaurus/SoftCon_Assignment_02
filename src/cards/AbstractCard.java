package cards;

import Turn.State.TurnState;
import cards.cards.cardInterfaces.bonusSystemInterface.BonusSystem;
import dice.DiceTower;

public abstract class AbstractCard {

    protected String name;
    protected int temporaryPoints;

    protected int TuttoRequiredForPoints;
    public boolean endTurn;
    protected boolean KeepAllValidDice;
    protected boolean Immunity;
    protected boolean EndGame;

    private DiceTower diceTower;
    private BonusSystem TutoBonus;
    private String descripiton;
    private int bonusPoints;


    public AbstractCard(){
    }

    public DiceTower getDiceTower(){
        return diceTower;
    }


    //what needs to be done:
    //




    private TurnState turnState;



    public TurnState getTurnState() {
        return turnState;
    }
    private boolean checkBonusCondition(){
        return diceTower.madeTutto();
    }




    //public final boolean skipTurn;
    // needs to be added to Constructor



}



