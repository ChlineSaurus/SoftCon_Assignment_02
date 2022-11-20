package Turn;

public class AddScore implements TurnState{
    Turn aTurn;

    public AddScore(){}

    @Override
    public void next(Turn aTurn) {
        /*add TurnScore to player score
          delete TurnScore*/
        System.out.println("We are in Addition");
        aTurn.setState(new SetWon());
    }
}
