package dice;

import java.util.HashMap;
import java.util.Map;

public enum DiceFace {
      One(1, """
            +-------+
            |       |
            |   o   |
            |       |
            +-------+"""),
      Two(2, """
            +-------+
            | o     |
            |       |
            |     o |
            +-------+"""),
      Three(3, """
            +-------+
            | o     |
            |   o   |
            |     o |
            +-------+"""),
      Four(4, """
            +-------+
            | o   o |
            |       |
            | o   o |
            +-------+"""),
      Five(5, """
            +-------+
            | o   o |
            |   o   |
            | o   o |
            +-------+"""),
      Six(6, """
            +-------+
            | o   o |
            | o   o |
            | o   o |
            +-------+""");

      public final Integer integerValue;
      private final String repString;
      private static final Map<Integer, DiceFace> map = new HashMap<>();

      DiceFace(Integer integerValue, String repString) {
            this.integerValue = integerValue;
            this.repString = repString;
      }

      static {
            for (DiceFace aDiceName : DiceFace.values()) {
                  map.put(aDiceName.integerValue, aDiceName);
            }
      }

      public static DiceFace get_Enum(int value) {
            return map.get(value);
      }

      public static String represent(DiceFace aDiceFace) {
            return aDiceFace.repString;
      }
}
