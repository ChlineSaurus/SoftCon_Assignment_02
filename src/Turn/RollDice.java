package Turn;

public class RollDice implements TurnState{
    Turn aTurn;
    public RollDice(){

    }
    @Override
    public void next(Turn aTurn) {
        /*Roll Dice*/
        decideIfNull();
        aTurn.setState(new EvaluateDice());
    }
    private void decideIfNull(){
        /* must be implemented*/
    }
}
