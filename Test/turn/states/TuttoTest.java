package turn.states;

import Turn.State.CurrentlyPlaying;
import Turn.State.TurnState;
import Turn.State.Tutto;
import Turn.Turn;
import cards.cards.cardtypes.Fireworks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import players.PlayerManager;
import turn.SetUpSingelton;

import java.lang.reflect.Field;

public class TuttoTest {
    SetUpSingelton setUpSingelton = new SetUpSingelton();
    PlayerManager playerManager = setUpSingelton.getSingelton();
    Turn aTurn = new Turn();

    @Test
    public void TuttoWithFirework() throws Exception{
        setUpSingelton.cleanUpSingelton();
        aTurn.setCurrentState(new Tutto(aTurn));
        aTurn.turnCard = new Fireworks();
        aTurn.execute();
        Field aTurnFields=aTurn.getClass().getDeclaredField("currentState");
        aTurnFields.setAccessible(true);
        TurnState state=(TurnState) aTurnFields.get(aTurn);
        Assertions.assertEquals(CurrentlyPlaying.class, state.getClass());
    }
}
