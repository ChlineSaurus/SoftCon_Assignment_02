package Turn;

public class StartPlayerTurn implements TurnState{
    Turn aTurn;
    public StartPlayerTurn(){
    }
    @Override
    public void next(Turn aTurn) {
        System.out.println("I am in StartPlayerTurn");
        aTurn.setState(new DrawCard());
    }
}
