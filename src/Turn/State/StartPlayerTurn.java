package Turn.State;

import exceptions.IllegalUserInputExeption;

import java.io.IOException;

public class StartPlayerTurn implements TurnState {
    Turn aTurn;
    public StartPlayerTurn(Turn aTurn){
        this.aTurn = aTurn;
    }
    @Override
    public void next(Turn aTurn) throws IOException, IllegalUserInputExeption {
        System.out.println("I am in StartPlayerTurn");
        //here a card should be drawn...
        // if card == nullcard then end turn
        aTurn.setState(new CurrentlyPlaying(aTurn));
    }
    public void display(){
        //here should be displayed something...
    }
}
