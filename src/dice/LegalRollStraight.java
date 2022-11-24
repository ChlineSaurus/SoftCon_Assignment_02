package dice;

import java.util.List;

public class LegalRollStraight implements LegalRoll {



    @Override
    public boolean validateDice(List<Dice> notTakenDices,List<Dice> TakenDices) {

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
