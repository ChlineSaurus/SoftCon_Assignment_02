package dice.pointCalculator;

import dice.Dice;

import java.util.List;

public class PointCalculatorStraight implements PointCalculator {


    public int calculatePoints(List<Dice> newlyTakenDices) {
        return 0;
    }
    @Override
    public boolean validateDice(List<Dice> notTakenDices, List<Dice> TakenDices) {

        for (Dice notTakenDice: notTakenDices ){
            int faceValue = notTakenDice.getFaceValue().integerValue;
            boolean faceValueUnique=true;

            for (Dice takenDice:TakenDices){
                if (takenDice.getFaceValue().integerValue==faceValue) faceValueUnique = false;
            }
            if (faceValueUnique) return true;
        }
        return false;
    }

}

