package cards;

import Turn.State.TurnState;
import cards.cards.cardInterfaces.bonusSystemInterface.BonusSystem;
import dice.DiceTower;
import dice.calculateRollPoints.CalculatePointsNonNullRoll;
import dice.userDiceSelectionValidation.ValidateUserSelectedDice;

public abstract class AbstractCard {

    protected String name;
    protected int points;

    protected int TuttoRequiredForPoints;
    public boolean endTurn;
    protected boolean KeepAllValidDice;
    protected boolean Immunity;
    protected boolean EndGame;

    private DiceTower dices;
    private BonusSystem TutoBonus;
    private String descripiton;
    private int bonusPoints;
    public AbstractCard(){}

    public AbstractCard(String name, String description,BonusSystem bonusSystem, int bonusPoints, int TuttorequiredForPoints, int TuttoRequiredForBonus, TurnState turnState, CalculatePointsNonNullRoll calculatePointsNonNullRoll, ValidateUserSelectedDice validateUserSelectedDice){
        this.dices=new DiceTower(calculatePointsNonNullRoll,validateUserSelectedDice);
        this.name=name;
        this.descripiton=description;
        this.bonusPoints=bonusPoints;


    }
    public AbstractCard(String name, boolean endTurn){
        this.endTurn=endTurn;
        this.name=name;
    }
    public DiceTower getDiceTower(){
        return dices;
    }


    //what needs to be done:
    //




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



