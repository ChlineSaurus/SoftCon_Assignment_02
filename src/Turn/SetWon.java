package Turn;

public class SetWon implements TurnState{
    Turn aTurn;
    public SetWon(){}

    @Override
    public void next(Turn aTurn) {
        /*if ScorePlayer bigger than maxScore
        set current player on winner
         */
        System.out.println("We are in setWon");
        aTurn.setState(new SwitchPlayer());
    }
}
