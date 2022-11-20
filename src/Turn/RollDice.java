package Turn;

public class RollDice implements TurnState{
    Turn aTurn;
    public RollDice(){

    }
    @Override
    public void next(Turn aTurn) {
        rollDice();
        decideIfNull();
        aTurn.setState(new EvaluateDice());
    }
    private void decideIfNull(){
        /* must be implemented*/
    }
    private void rollDice(){
        System.out.println(aTurn.score);
        aTurn.list.add(2);
        aTurn.list.add(4);
        System.out.println(aTurn.list);
    }
}
