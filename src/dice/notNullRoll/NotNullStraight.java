package dice.notNullRoll;

import dice.Dice;

import java.util.List;

public class NotNullStraight implements NotNullRoll {



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
