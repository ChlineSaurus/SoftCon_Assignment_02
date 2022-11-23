package Turn.State;

import exceptions.IllegalUserInputExeption;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface TurnState {

     void next(Turn aTurn) throws IOException, IllegalUserInputExeption;


    class Turn {
         protected int score = 0;
         protected int dices = 0;
         protected List<Integer> list=new ArrayList<Integer>();
         private Turn aTurn;
         private TurnState state = new StartPlayerTurn(aTurn){

         };

         public void setState(TurnState state) throws IOException, IllegalUserInputExeption {
             this.state = state;
             state.next(this);
         }
         public void nextState() throws IOException, IllegalUserInputExeption {state.next(this);}
     }
}
