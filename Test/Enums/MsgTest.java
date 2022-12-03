package Enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MsgTest {
    @Test
    public void TestStopOrContinueQuestion(){
        Assertions.assertEquals("Enter 's' if you want to stop or 'c' if you want to continue: ",Msg.stopOrContinueQuestion.message);
    }
    @Test
    public void TestillegalCharException(){
        Assertions.assertEquals("You input contained other symbols than numbers, spaces and commas. Please give a valid Input",Msg.illegalCharException.message);
    }
}