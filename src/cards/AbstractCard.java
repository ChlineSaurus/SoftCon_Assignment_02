package cards;

import cards.cards.cardInterfaces.bonusSystemInterface.BonusSystem;
import cards.cards.cardInterfaces.bonusSystemInterface.PlusPoints;
import cards.cards.cardInterfaces.bonusSystemInterface.TimesX2Points;
import dice.DiceTower;
import dice.pointCalculator.PointsCalculatorStandard;
import dice.diceSelectionValidator.DiceSelectionValidatorStandard;
import exceptions.IllegalUserInputExeption;

public abstract class AbstractCard {

    protected String name;
    protected String description;
    protected boolean endTurn;
    protected boolean immunity;
    protected TuttoRequired requiredForPoints;
    protected TuttoRequired requiredForBonus;
    protected DiceTower diceTower=new DiceTower();
    protected int deductionPoints;
    protected BonusSystem bonusSystem;
    protected int bonusPoints;
    public AbstractCard(){
        immunity=false;
        endTurn=false;
        deductionPoints=0;
        setBonusSystemStandard();
        description="still needs to implemented";
        name="still needs to be no name";

    }



    protected void setBonusSystemStandard(){
        bonusSystem=new PlusPoints();
    }
    protected void setBonusSystemX2(){
        bonusSystem=new TimesX2Points();
    }    public boolean isImmunity(){
        return immunity;
    }
    private void tuttoAchieved(){
        if (!isPointConditionAchieved()){
            requiredForPoints=TuttoRequired.getEnum((requiredForPoints.integerValue)-1);
        }
        if (!isBonusConditionAchieved()){
            requiredForBonus=TuttoRequired.getEnum(requiredForBonus.integerValue-1);
        }
    }
    public void userTriesToEndTurn() throws IllegalUserInputExeption {
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
    public boolean haveToContinueRolling(){
        return this.requiredForPoints!=TuttoRequired.Zero;
    }



    public int addBonus(int currentPoints){
        int addBoni=0;
        tuttoAchieved();
        if (requiredForBonus==TuttoRequired.Zero){
            addBoni= bonusSystem.bonusPoints(bonusPoints,currentPoints);
        }
        return addBoni;
    }

    public void injectStrategyToTower(DiceTower aDiceTower) {
        aDiceTower.setStrategy(new PointsCalculatorStandard(), new DiceSelectionValidatorStandard());
    }
    public int getDeductPoints() {
            return deductionPoints;
        }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }


    //what needs to be done:
    //
    public boolean isEndTurn(){
        return endTurn;
    }









    //public final boolean skipTurn;
    // needs to be added to Constructor



}



