package Turn;

public class Turn {
    protected int score = 0;
    protected int dices = 0;
    private TurnState state = new StartPlayerTurn();

    public void setState(TurnState state){
        this.state = state;
        state.next(this);
    }
    public void nextState(){state.next(this);}
}
