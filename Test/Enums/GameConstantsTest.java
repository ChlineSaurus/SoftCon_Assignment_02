package Enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameConstantsTest {
    @Test
    public void TestMinAllowedPlayers(){
        Assertions.assertEquals(2, GameConstants.minAllowedPlayers.definedConstant);
    }
    @Test
    public void TestMaxAllowedPoints(){
        Assertions.assertEquals(1000, GameConstants.minAllowedPoints.definedConstant);
    }
}
