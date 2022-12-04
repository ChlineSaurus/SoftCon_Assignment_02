package turn;

import Turn.State.EndTurn;
import Turn.State.StartPlayerTurn;
import Turn.State.TurnState;
import Turn.Turn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import players.PlayerManager;

import java.lang.reflect.Field;

public class EndTurnTest {
    SetUpSingelton setUpSingelton = new SetUpSingelton();
    PlayerManager playerManager = setUpSingelton.getSingelton();
    Turn aTurn = new Turn();

    @Test
    public void endTurn() throws Exception{
        setUpSingelton.cleanUpSingelton();
        aTurn.temporaryScore = 100;
        aTurn.setCurrentState(new EndTurn(aTurn));
        aTurn.execute();
        Assertions.assertEquals(0, aTurn.temporaryScore);
        Field aTurnFields=aTurn.getClass().getDeclaredField("currentState");
        aTurnFields.setAccessible(true);
        TurnState state=(TurnState) aTurnFields.get(aTurn);
        Assertions.assertEquals(StartPlayerTurn.class, state.getClass());
    }
}
