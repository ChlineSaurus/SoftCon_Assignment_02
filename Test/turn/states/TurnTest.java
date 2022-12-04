package turn.states;

import Turn.State.CurrentlyPlaying;
import Turn.State.EndTurn;
import Turn.State.StartPlayerTurn;
import Turn.State.TurnState;
import Turn.Turn;
import cards.Deck;
import cards.cards.cardtypes.X2;
import dice.DiceFace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import players.PlayerManager;
import turn.DiceSetUp;
import turn.SetUpSingelton;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class TurnTest {

    SetUpSingelton setUpSingelton = new SetUpSingelton();
    PlayerManager playerManager = setUpSingelton.getSingelton();
    Turn aTurn = new Turn();

        @Test
        public void setTurnTest() throws Exception{
            setUpSingelton.cleanUpSingelton();
            aTurn.setCurrentState(new EndTurn(aTurn));
            Field aTurnFields=aTurn.getClass().getDeclaredField("currentState");
            aTurnFields.setAccessible(true);
            TurnState state=(TurnState) aTurnFields.get(aTurn);
            Turn bTurn= new Turn();
            EndTurn endTurn=new EndTurn(bTurn);
            Assertions.assertEquals(state.getClass(), endTurn.getClass());
        }

    @Test
    public void newTurn() throws Exception{
        setUpSingelton.cleanUpSingelton();
        aTurn.temporaryScore = 100;
        aTurn.pointsToDeduct = 100;
        aTurn.setCurrentState(new CurrentlyPlaying(aTurn));
        aTurn.newTurn();
        Assertions.assertEquals(0, aTurn.temporaryScore);
        Assertions.assertEquals(0, aTurn.pointsToDeduct);
        Field aTurnFields=aTurn.getClass().getDeclaredField("currentState");
        aTurnFields.setAccessible(true);
        TurnState state=(TurnState) aTurnFields.get(aTurn);
        Assertions.assertEquals(StartPlayerTurn.class,state.getClass());
    }

    @Test
    public void emptyDeckRefill() throws Exception{
        setUpSingelton.cleanUpSingelton();
        for(int i = 0; i < 57; i++) {
            aTurn.draw();
        }
        Field deck = aTurn.getClass().getDeclaredField("deck");
        deck.setAccessible(true);
        Deck aDeck = (Deck) deck.get(aTurn);
        Assertions.assertFalse(aDeck.isEmpty());
    }

    @Test
    public void lawOfDemeterDiceTowerTest() throws Exception {
        setUpSingelton.cleanUpSingelton();
        DiceSetUp.DiceTowerSetUp(aTurn, new X2());
        aTurn.newRoll();
        DiceSetUp.tuttoSetup(aTurn);
        Assertions.assertTrue(aTurn.validDiceExist());
        ArrayList<DiceFace> dicesToRemove = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            dicesToRemove.add(DiceFace.One);
        }
        aTurn.removeDice(dicesToRemove);
        aTurn.tuttoMade();
    }
}
