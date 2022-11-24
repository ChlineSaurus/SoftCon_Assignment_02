package dice;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    static final DiceFace[] FaceValues = DiceFace.values();
    private DiceFace currentFaceValue;

    public DiceFace roll(){
        int randomIndex = ThreadLocalRandom.current().nextInt(FaceValues.length);
        currentFaceValue = FaceValues[randomIndex];
        return currentFaceValue;
    }

    public DiceFace getFaceValue()   {
        assert currentFaceValue!=null;
        return currentFaceValue;
    }
}
