package Turn;

public class SwitchPlayer implements TurnState{
    Turn aTurn;
    public SwitchPlayer(){}

    @Override
    public void next(Turn aTurn) {
        System.out.println("we are switching player");
        aTurn.setState(new EvaluateWon());
    }
}
