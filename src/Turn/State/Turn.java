package Turn.State;

import java.util.ArrayList;
import java.util.List;

public class Turn extends TurnState.Turn {
    Turn aTurn;
    protected int score = 0;
    protected int dices = 0;
    protected List<Integer> list=new ArrayList<Integer>();
    private TurnState state = new StartPlayerTurn(aTurn){
    };

    public void setState(TurnState state){
        this.state = state;
        state.next(this);
    }
    public void nextState(){state.next(this);}
}
