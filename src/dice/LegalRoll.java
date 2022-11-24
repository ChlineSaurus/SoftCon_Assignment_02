package dice;

import java.util.List;

public interface LegalRoll {

    public boolean validateDice(List<Dice> NotTakenDices,List<Dice> TakenDices);
}


