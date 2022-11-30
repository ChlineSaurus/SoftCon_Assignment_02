package cards.cards.cardtypes;


import cards.AbstractCard;
import cards.TuttoRequired;
import dice.DiceTower;
import dice.pointCalculator.PointsCalculatorStandard;
import dice.diceSelectionValidator.DiceSelectionValidatorFirework;

public class Fireworks extends AbstractCard {


    public Fireworks(){
        immunity=true;
        bonusPoints=0;
        name="Fireworks";
        requiredForPoints= TuttoRequired.Zero;
        requiredForBonus=TuttoRequired.Zero;


    }
    @Override
    public void injectStrategyToTower(DiceTower aDiceTower) {
        aDiceTower.setStrategy(new PointsCalculatorStandard(), new DiceSelectionValidatorFirework());
    }

    @Override
    public boolean haveToContinueRolling() {
        return true;
    }

}
