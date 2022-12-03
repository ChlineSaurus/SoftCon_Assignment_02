package dice;

import java.util.Random;

public class Dice {
    public final DiceFace[] FaceValues = DiceFace.values();
    private DiceFace currentFaceValue;
    private final Random aRandom = new Random();
    public DiceFace roll(){
        int randomIndex = aRandom.nextInt(FaceValues.length);
        currentFaceValue = FaceValues[randomIndex];
        return currentFaceValue;
    }

    public DiceFace getFaceValue()   {
        assert currentFaceValue!=null;
        return currentFaceValue;
    }
}
