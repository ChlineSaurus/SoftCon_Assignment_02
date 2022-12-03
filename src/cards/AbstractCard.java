package cards;

import cards.cards.cardInterfaces.bonusSystemInterface.BonusSystem;
import cards.cards.cardInterfaces.bonusSystemInterface.PlusPoints;
import cards.cards.cardInterfaces.bonusSystemInterface.TimesX2Points;
import dice.DiceTower;
import dice.notNullRoll.NotNullRollStandard;
import dice.pointCalculator.PointsCalculatorStandard;
import dice.diceSelectionValidator.DiceSelectionValidatorStandard;
import exceptions.IllegalUserInputException;

public abstract class AbstractCard {

    protected String name;

    protected String description;
    protected boolean endTurn;
    protected boolean immunity;
    protected TuttoRequired requiredForPoints;
    protected TuttoRequired requiredForBonus;
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
    }
    public boolean isImmunity(){
        return immunity;
    }
    public int tuttoAchieved(int currentPoints){
        if (!isPointConditionAchieved()){
            requiredForPoints=TuttoRequired.getEnum((requiredForPoints.integerValue)-1);
        }
        if (!isBonusConditionAchieved()){
            requiredForBonus=TuttoRequired.getEnum(requiredForBonus.integerValue-1);
        }
        if (isBonusConditionAchieved()) {
            return bonusSystem.bonusPoints(bonusPoints, currentPoints);
        }
        return currentPoints;
    }
    public void userTriesToEndTurn() throws IllegalUserInputException {
        if (requiredForPoints!=TuttoRequired.Zero){
            throw new IllegalUserInputException("If you end your turn now, you'll recieve zeropoints, roll again!, type 'r'");
        }
    }
    protected boolean isBonusConditionAchieved(){
        return this.requiredForBonus==TuttoRequired.Zero;
    }
    protected boolean isPointConditionAchieved(){
        return this.requiredForPoints==TuttoRequired.Zero;
    }
    public boolean haveToContinueRolling(){
        return this.requiredForPoints!=TuttoRequired.Zero;
    }

    public void injectStrategyToTower(DiceTower aDiceTower) {
        aDiceTower.setStrategy(new PointsCalculatorStandard(), new DiceSelectionValidatorStandard(), new NotNullRollStandard());
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

    public boolean isEndTurn(){
        return endTurn;
    }
}



