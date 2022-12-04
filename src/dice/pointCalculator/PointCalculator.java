package dice.pointCalculator;

import dice.Dice;

import java.util.List;

public interface PointCalculator {
    public int calculatePoints(List<Dice> newlyTakenDices);
}
