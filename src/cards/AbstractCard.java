package cards;

import cards.cards.cardInterfaces.bonusSystemInterface.BonusSystem;
import cards.cards.cardInterfaces.deductPoints.DeductPoints;
import dice.DiceTower;
import exceptions.IllegalUserInputExeption;

public abstract class AbstractCard {

    protected String name;
    protected int temporaryPoints;

    protected int TuttoRequiredForPoints;
    protected boolean endTurn;
    protected boolean KeepAllValidDice;
    protected boolean Immunity;
    protected boolean EndGame;
    TuttoRequired requiredForPoints;
    TuttoRequired requiredForBonus;

    protected DiceTower diceTower=new DiceTower();
    protected DeductPoints deductPoints;
    protected BonusSystem TutoBonus;
    protected String descripiton;
    protected int bonusPoints;
    private void tuttoAchieved(){
        if (this.requiredForPoints!=TuttoRequired.Zero){
            requiredForPoints=TuttoRequired.getEnum((requiredForPoints.integerValue)-1);
        }
        if (this.requiredForBonus!=TuttoRequired.Zero){
            requiredForBonus=TuttoRequired.getEnum(requiredForBonus.integerValue-1);
        }
    }
    public void userTrysToEndTurn() throws IllegalUserInputExeption {
        if (requiredForPoints!=TuttoRequired.Zero){
            throw new IllegalUserInputExeption("If you end your turn now, you'll recieve zeropoints, roll again!");
        }
    }



    public DiceTower getDiceTower(){
        return diceTower;
    }
    private boolean isBonusConditionAchieved(){
        return this.requiredForBonus==TuttoRequired.Zero;
    }
    private boolean isPointConditionAchieved(){
        return this.requiredForPoints==TuttoRequired.Zero;
    }
    public void roll(){
        diceTower.rollNotTakenDices();
    }
    public boolean isRollValid(){
        return diceTower.notNullRoll();
    }


    public void addPoints(){

    }


    //what needs to be done:
    //








    public boolean isEndTurn(){
        return endTurn;
    }
    private void checkBonusCondition(){
        if( diceTower.madeTutto()){
            //pass
        }
    }




    //public final boolean skipTurn;
    // needs to be added to Constructor



}



