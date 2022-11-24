package dice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LegalRollNonStraight implements LegalRoll {
    private Map<Integer,Integer> diceCounter = new HashMap<Integer, Integer>();

    @Override
    public boolean validateDice(List<Dice> notTakenDices,List<Dice> TakenDices)
    {
        for (Dice dice: notTakenDices){
            Integer faceValue=dice.getFaceValue().integerValue;

            if (faceValue!=5 && faceValue!=1){
                if (diceCounter.containsKey(faceValue)){
                    diceCounter.put(faceValue,diceCounter.get(faceValue)+1);
                }
                else{
                    diceCounter.put(faceValue,1);
                }
            }

            else{
                return true;
            }
        }

        for (Integer occurences:diceCounter.values()){

            if (occurences>=3){
                return true;
            }
        }

        return false;
    }
}

