package cards;

import cards.cards.cardInterfaces.bonusSystemInterface.BonusSystem;
import dice.DiceTower;
import exceptions.IllegalUserInputExeption;

public abstract class AbstractCard {

    protected String name;
    protected String descripiton;
    protected int temporaryPoints;

    protected boolean endTurn;

    protected boolean immunity;
    TuttoRequired requiredForPoints;
    TuttoRequired requiredForBonus;

    protected DiceTower diceTower=new DiceTower();
    protected int deductPoints;
    protected BonusSystem TutoBonus;
    public AbstractCard(){
        immunity=false;
        endTurn=false;
    }

    protected int bonusPoints;
    private void tuttoAchieved(){
        if (!isPointConditionAchieved()){
            requiredForPoints=TuttoRequired.getEnum((requiredForPoints.integerValue)-1);
        }
        if (!isBonusConditionAchieved()){
            requiredForBonus=TuttoRequired.getEnum(requiredForBonus.integerValue-1);
        }
    }
    public void userTrysToEndTurn() throws IllegalUserInputExeption {
        if (requiredForPoints!=TuttoRequired.Zero){
            throw new IllegalUserInputExeption("If you end your turn now, you'll recieve zeropoints, roll again!, type 'r'");
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
        if (!isRollValid() && !immunity){
            temporaryPoints=0;
            //maybe return a tuple

        }
    }
    public boolean isRollValid(){
        return diceTower.notNullRoll();
    }


    public int addBonus(int currentPoints){
        int addBoni=0;
        tuttoAchieved();
        if (requiredForBonus==TuttoRequired.Zero){
            addBoni=TutoBonus.bonusPoints(bonusPoints,currentPoints);
        }
        return addBoni;
    }

    public int getDeductPoints() {
            return deductPoints;
        }

    public String getName(){
        return name;
    }
    public String getDescripiton(){
        return descripiton;
    }


    //what needs to be done:
    //
    public boolean isEndTurn(){
        return endTurn;
    }









    //public final boolean skipTurn;
    // needs to be added to Constructor



}



