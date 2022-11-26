package dice.diceTowerTypes;


import dice.DiceTower;
import dice.calculateRollPoints.PointsStraightNonNullRoll;
import dice.userDiceSelectionValidation.ValidUserSelectionStraight;

public class DiceTowerStraight extends DiceTower {


    public DiceTowerStraight() {
        super ();
        this.pointCalculator =new PointsStraightNonNullRoll();
        this.validateUserSelectedDice=new ValidUserSelectionStraight();
    }
}
