package turn;

import Turn.State.CurrentlyPlaying;
import Turn.State.EndTurn;
import Turn.State.TurnState;
import Turn.Turn;
import cards.cards.cardtypes.Fireworks;
import cards.cards.cardtypes.X2;
import dice.DiceFace;
import exceptions.IllegalUserInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import players.PlayerManager;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class CurrentlyPlayingTest {

    SetUpSingelton setUpSingelton = new SetUpSingelton();
    PlayerManager playerManager = setUpSingelton.getSingelton();
    Turn aTurn = new Turn();

    @Test
    public void CurrentlyPlayingInputValidationInvalid() throws Exception{
        setUpSingelton.cleanUpSingelton();
        CurrentlyPlaying turnState=new CurrentlyPlaying(aTurn);
        Method specialTurnStateMethod= turnState.getClass().getDeclaredMethod("diceRemovalAttempt");
        specialTurnStateMethod.setAccessible(true);
        aTurn.newRoll();
        Exception e = Assertions.assertThrows(InvocationTargetException.class, () -> {
            specialTurnStateMethod.invoke(turnState);
        });
        Assertions.assertEquals(IllegalUserInputException.class, e.getCause().getClass());
    }

    @Test
    public void CurrentlyPlayingInputValidationValid() throws Exception{
        setUpSingelton.cleanUpSingelton();
        CurrentlyPlaying turnState=new CurrentlyPlaying(aTurn);
        Method specialTurnStateMethod= turnState.getClass().getDeclaredMethod("diceRemovalAttempt");
        specialTurnStateMethod.setAccessible(true);
        aTurn.rollNotTakenDices();
        DiceSetUp.tuttoSetup(aTurn);
        ArrayList<DiceFace> diceToRemove = new ArrayList<>();
        diceToRemove.add(DiceFace.One);
        aTurn.turnCard = new X2();
        aTurn.removeDice(diceToRemove);
        Assertions.assertTrue((Boolean) specialTurnStateMethod.invoke(turnState));
    }

    @Test
    public void NullRollActionNoImmunity() throws Exception {
        setUpSingelton.cleanUpSingelton();
        aTurn.setCurrentState(new CurrentlyPlaying(aTurn));
        CurrentlyPlaying turnState = new CurrentlyPlaying(aTurn);
        Method specialTurnStateMethod = turnState.getClass().getDeclaredMethod("nullRollAction");
        specialTurnStateMethod.setAccessible(true);
        aTurn.turnCard = new X2();
        aTurn.temporaryScore = 100;
        DiceSetUp.tuttoSetup(aTurn);
        specialTurnStateMethod.invoke(turnState);
        Field aTurnFields=aTurn.getClass().getDeclaredField("currentState");
        aTurnFields.setAccessible(true);
        TurnState state=(TurnState) aTurnFields.get(aTurn);
        Assertions.assertEquals(CurrentlyPlaying.class, state.getClass());
        DiceSetUp.NullSetup(aTurn);
        specialTurnStateMethod.invoke(turnState);
        aTurnFields=aTurn.getClass().getDeclaredField("currentState");
        aTurnFields.setAccessible(true);
        state=(TurnState) aTurnFields.get(aTurn);
        Assertions.assertEquals(EndTurn.class, state.getClass());
        Assertions.assertEquals(0, aTurn.temporaryScore);
    }

    @Test
    public void NullRollActionImmunity() throws Exception {
        setUpSingelton.cleanUpSingelton();
        aTurn.setCurrentState(new CurrentlyPlaying(aTurn));
        CurrentlyPlaying turnState = new CurrentlyPlaying(aTurn);
        Method specialTurnStateMethod = turnState.getClass().getDeclaredMethod("nullRollAction");
        specialTurnStateMethod.setAccessible(true);
        aTurn.turnCard = new Fireworks();
        aTurn.temporaryScore = 100;
        DiceSetUp.NullSetup(aTurn);
        specialTurnStateMethod.invoke(turnState);
        Field aTurnFields=aTurn.getClass().getDeclaredField("currentState");
        aTurnFields.setAccessible(true);
        TurnState state=(TurnState) aTurnFields.get(aTurn);
        Assertions.assertEquals(EndTurn.class, state.getClass());
        Assertions.assertEquals(100, aTurn.temporaryScore);
    }
}
