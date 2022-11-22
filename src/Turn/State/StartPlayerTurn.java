package Turn.State;

public class StartPlayerTurn implements TurnState {
    Turn aTurn;
    public StartPlayerTurn(Turn aTurn){
        this.aTurn = aTurn;
    }
    @Override
    public void next(Turn aTurn) {
        System.out.println("I am in StartPlayerTurn");
        aTurn.setState(new CurrentlyPlaying(aTurn));
    }
}
