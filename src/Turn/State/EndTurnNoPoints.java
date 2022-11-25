package Turn.State;

import exceptions.IllegalUserInputExeption;

import java.io.IOException;

public class EndTurnNoPoints implements TurnState{
    @Override
    public void next(Turn aTurn) throws IOException, IllegalUserInputExeption {
        aTurn.score=0;
    }
}
