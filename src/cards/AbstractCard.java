package cards;

import cards.cards.cardInterfaces.bonusSystemInterface.BonusSystem;
import dice.DiceTower;

public abstract class AbstractCard {

    protected String name;
    protected int temporaryPoints;

    protected int TuttoRequiredForPoints;
    protected boolean endTurn;
    protected boolean KeepAllValidDice;
    protected boolean Immunity;
    protected boolean EndGame;

    protected DiceTower diceTower;
    protected BonusSystem TutoBonus;
    protected String descripiton;
    protected int bonusPoints;




    public AbstractCard(){
    }

    public DiceTower getDiceTower(){
        return diceTower;
    }


    //what needs to be done:
    //








    public boolean isEndTurn(){
        return endTurn;
    }
    private boolean checkBonusCondition(){
        return diceTower.madeTutto();
    }




    //public final boolean skipTurn;
    // needs to be added to Constructor



}



