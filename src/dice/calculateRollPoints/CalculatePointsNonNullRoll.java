package dice.calculateRollPoints;

import dice.Dice;

import java.util.List;

public interface CalculatePointsNonNullRoll {
    public int calculatePoints(List<Dice> newlyTakenDices);
    public boolean validateDice(List<Dice> notTakenDices, List<Dice> takenDices);
}
