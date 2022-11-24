package dice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateNonStraight implements ValidateDice {
    private Map<DiceFace,Integer> diceCounter = new HashMap<DiceFace, Integer>();

    @Override
    public boolean validateDice(List<Dice> notTakenDices,List<Dice> TakenDices)
    {
        for (Dice dice: notTakenDices){
            DiceFace faceValue=dice.getFaceValue();

            if (faceValue!=DiceFace.Five && faceValue!=DiceFace.One){
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

