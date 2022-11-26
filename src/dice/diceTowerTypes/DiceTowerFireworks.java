package dice.diceTowerTypes;

import dice.DiceTower;
import dice.calculateRollPoints.PointsNonStraightNonNullRoll;
import dice.userDiceSelectionValidation.MustTakeAllValidDice;

public class DiceTowerFireworks extends DiceTower {
    public DiceTowerFireworks(){
        super();
        this.pointCalculator= new PointsNonStraightNonNullRoll();
        this.validateUserSelectedDice=new MustTakeAllValidDice();
    }
}
