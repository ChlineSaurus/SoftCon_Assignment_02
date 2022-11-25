package dice.calculateRollPoints;

import dice.Dice;

import java.util.List;

public interface CalculateRollPoints {
    public int calculatePoints(List<Dice> newlyTakenDices);
}
