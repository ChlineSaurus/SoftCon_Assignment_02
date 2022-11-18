package UI;

import java.util.HashMap;
import java.util.Map;

public enum DiceRepresentation {
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

      private final Integer value;
      private final String repString;
      private static final Map<Integer, String> map = new HashMap<>();

      DiceRepresentation(Integer value, String repString) {
            this.value = value;
            this.repString = repString;
      }

      static {
            for (DiceRepresentation diceName : DiceRepresentation.values()) {
                  map.put(diceName.value, diceName.repString);
            }
      }

      public static String represent(int value) {
            return map.get(value);
      }
}
