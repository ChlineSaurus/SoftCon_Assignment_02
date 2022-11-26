package cards;

import java.util.HashMap;
import java.util.Map;

public enum TuttoRequired {
    Two(2),
    One(1),
    Zero(0);
    public final Integer integerValue;
    private static final Map<Integer, TuttoRequired> map = new HashMap<>();

    TuttoRequired(Integer integerValue) {
        this.integerValue = integerValue;

    }

    static {
        for (TuttoRequired tuttoRequired : TuttoRequired.values()) {
            map.put(tuttoRequired.integerValue, tuttoRequired);
        }
    }

    public static TuttoRequired getEnum(int value) {
        return map.get(value);
    }


}
