package cards.cards.cardtypes;


import cards.AbstractCard;
import cards.TuttoRequired;
import dice.DiceTower;
import dice.calculateRollPoints.PointsNonStraightNonNullRoll;
import dice.userDiceSelectionValidation.MustTakeAllValidDice;

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
        aDiceTower.setStrategy(new PointsNonStraightNonNullRoll(), new MustTakeAllValidDice());
    }

}
