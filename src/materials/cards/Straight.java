package materials.cards;

import materials.Dice;

import java.util.List;

public class Straight implements TutoCondition {


    @Override
    public boolean tutoRequirements(List<Dice> dices) {

        for (Dice dice:dices){
            int faceValue=dice.getFaceValue();


        }
        return false;
    }

}
