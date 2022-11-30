package dice.pointCalculator;

import dice.Dice;

import java.util.List;

public interface PointCalculator {
    public int calculatePoints(List<Dice> newlyTakenDices);
    public boolean validateDice(List<Dice> notTakenDices, List<Dice> takenDices);
}
