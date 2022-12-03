package dice.notNullRoll;

import dice.Dice;

import java.util.List;

public interface NotNullRoll {
    public boolean notNullRoll(List<Dice> notTakenDices, List<Dice> takenDices);
}
