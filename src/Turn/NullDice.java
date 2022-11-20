package Turn;

public class NullDice implements TurnState{
    Turn aTurn;
    public NullDice(){}

    @Override
    public void next(Turn aTurn) {
        /* depends on card evtl
        aTurn.setState(new RollDice)
         */
        deleteScore();
        System.out.println("Unfortunately there where Null Die");
        aTurn.setState(new AddScore());
    }
    private void deleteScore(){
        /*must be implemented

         */
    }
}
