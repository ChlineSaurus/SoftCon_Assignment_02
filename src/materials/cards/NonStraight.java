package materials.cards;

import materials.Dice;

import java.util.List;

public class NonStraight implements ValidDice{

    @Override
    public boolean validDice(List<Dice> dices) {
        for (Dice dice: dices){
            int faceValue=dice.getFaceValue();


        }
        return false;
    }
}
