package cards.cards.cardtypes;

import cards.AbstractCard;
import cards.TuttoRequired;
import dice.DiceTower;
import dice.diceSelectionValidator.DiceSelectionValidatorStandard;
import dice.notNullRoll.NotNullRollStandard;
import dice.pointCalculator.PointCalculatorNoPointsForRoll;

public class PlusMinus extends AbstractCard {

    public PlusMinus() {

        name="PlusMinus";
        description= """
                You must try to accomplish a 'Tutto' and may not stop before you do. If you roll a null, you don't
                score any points. But if you succeed, you score exactly 1000 points, irrespective of the number of
                points you have rolled. Besides this, the leading player has 1000 Points deducted.""";
        bonusPoints=1000;
        deductionPoints=1000;
        requiredForPoints= TuttoRequired.One;
        requiredForBonus=TuttoRequired.One;
    }

    @Override
    public void injectStrategyToTower(DiceTower aDiceTower){
        aDiceTower.setStrategy(new PointCalculatorNoPointsForRoll(),new DiceSelectionValidatorStandard(), new NotNullRollStandard());
    }
}
