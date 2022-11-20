package Turn;

public class Terminate implements TurnState{
    Turn aTurn;
    public Terminate(){}

    @Override
    public void next(Turn aTurn) {
        displayWinner();
    }
    public void displayWinner(){
        System.out.println("Hi I am displaying the winner");
    }
}
