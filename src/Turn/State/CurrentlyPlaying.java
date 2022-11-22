package Turn.State;

public class CurrentlyPlaying implements TurnState{
    Turn aTurn;

    public CurrentlyPlaying(Turn aTurn){this.aTurn = aTurn;}
    @Override
    public void next(Turn aTurn) {
        int i = 0;
        System.out.println("I am currently playing");
        if (i ==0){
            aTurn.setState(new Tutto(aTurn));
        }
        else{
            aTurn.setState(new Tutto(aTurn));
        }
    }
}
