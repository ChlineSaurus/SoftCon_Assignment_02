package dice.diceTowerTypes;

import dice.DiceTower;
import dice.calculateRollPoints.PointsNonStraightNonNullRoll;
import dice.userDiceSelectionValidation.ValidateUserSelectionNonStraight;

public class DiceTowerNonStraight extends DiceTower {
    public DiceTowerNonStraight(){
        super();
        this.pointCalculator=new PointsNonStraightNonNullRoll();
        this.validateUserSelectedDice=new ValidateUserSelectionNonStraight();
    }

}
