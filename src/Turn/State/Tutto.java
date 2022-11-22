package Turn.State;

import java.io.IOException;

public class Tutto implements TurnState{
    Turn aTurn;

    public Tutto(Turn aTurn){this.aTurn = aTurn;}
    @Override
    public void next(Turn aTurn) throws IOException {
        System.out.println("I am in  Tutto");
        int i = 1;
        if (i==0){
            System.out.println("Drawing new card");
            aTurn.setState(new CurrentlyPlaying(aTurn));
        }
        else{
            aTurn.setState(new EndTurn(aTurn));
        }
    }
}
