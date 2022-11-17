package materials.cards;

import materials.Dice;

import java.util.List;

public interface TutoCondition {

    public boolean tutoRequirements(List<Dice> dices);
}

