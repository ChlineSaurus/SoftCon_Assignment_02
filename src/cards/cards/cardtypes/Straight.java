package cards.cards.cardtypes;


import cards.AbstractCard;
import cards.TuttoRequired;
import dice.DiceTower;
import dice.pointCalculator.PointCalculatorStraight;
import dice.diceSelectionValidator.DiceSelectionValidatorStraight;

public class Straight extends AbstractCard {
   public Straight(){
    bonusPoints=2000;
    name="Straight";
    description = """
            Attention! This card changes the rules for valid dice. You have to try to accomplish a 'Straight'
            and may not stop before you do. A 'Straight' consists of all six Numbers. As usual, you have to keep at
            least one valid die after each roll. In this case, a valid die is a die that shows a number that you have
            not yet put aside. If the roll doesn't contain a valid die, it counts as a null and you don't score any points.
            But if you accomplish a 'Straight' you score 2000 Points.
            """;
    requiredForPoints= TuttoRequired.One;
    requiredForBonus=TuttoRequired.One;

    }

    @Override
    public void injectStrategyToTower(DiceTower aDiceTower) {
       aDiceTower.setStrategy(new PointCalculatorStraight(), new DiceSelectionValidatorStraight());
    }
}
