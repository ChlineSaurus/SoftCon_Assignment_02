package Turn;

public class EvaluateDice implements TurnState{
    Turn aTurn;
    public EvaluateDice(){
    }

    @Override
    public void next(Turn aTurn) {
        System.out.println("I am evaluating the dices...");
        evaluateDice();
        int i = 3;
        if (i == 0){
            aTurn.setState((new NullDice()));
        } else if (i==1) {
            aTurn.setState(new MoreValidDice());
        }
        else {
            aTurn.setState(new NoMoreValidDice());
        }
    }
    private void evaluateDice(){
        /* must be implemented*/
    }

}
