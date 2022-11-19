package cards.cards;

import dice.Dice;

import java.util.List;

public interface TutoCondition {

    public boolean tutoRequirements(List<Dice> dices);
}

