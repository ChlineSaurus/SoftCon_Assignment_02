package materials.cards;

import materials.Dice;

import java.util.List;

public class Straight implements ValidDice{


    @Override
    public boolean validDice(List<Dice> dices) {
        for (Dice dice:dices){
            int faceValue=dice.getFaceValue();

        }
        return false;
    }
}
