package Turn;

public class DrawCard implements TurnState{
    Turn aTurn;
    public DrawCard(){

    }
    @Override
    public void next(Turn aTurn){
        drawCard();
        displayCard();
        myFunction();
        aTurn.setState(new RollDice());
    }
    public void myFunction(){

        System.out.println("Now i am in DrawCard");
        /*System.out.println(aTurn.score);*/
    }
    private void drawCard(){
        /*Must be implemented*/
    }
    private void displayCard(){
        /*Must be implemented*/
    }
}
