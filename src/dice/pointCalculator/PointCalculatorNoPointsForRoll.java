package dice.pointCalculator;

import dice.Dice;

import java.util.List;

public class PointCalculatorNoPointsForRoll implements PointCalculator {

    @Override
    public int calculatePoints(List<Dice> newlyTakenDices) {
        return 0;
    }
}

