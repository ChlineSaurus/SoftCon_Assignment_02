package cards.cards.cardtypes;


import cards.AbstractCard;
import cards.TuttoRequired;
import dice.DiceTower;
import dice.pointCalculator.PointsStraightNonNullRoll;
import dice.diceSelectionValidator.DiceSelectionValidatorStraight;

public class Straight extends AbstractCard {
   public Straight(){
    bonusPoints=2000;
    name="Straight";
    requiredForPoints= TuttoRequired.One;
    requiredForBonus=TuttoRequired.One;

    }

    @Override
    public void injectStrategyToTower(DiceTower aDiceTower) {
       aDiceTower.setStrategy(new PointsStraightNonNullRoll(), new DiceSelectionValidatorStraight());
    }
}
