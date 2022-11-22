package Turn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanInteractionManager {

    public void DisplayOrRoll()
            throws IOException {

        {
            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(System.in)
            );
            // make advanced with false input and repeated asking...while nextAction !="R"
            System.out.println("For displaying your score please enter \"D\" for rolling the Dice please enter \"R\"");
            String nextAction = inputReader.readLine();

            if (nextAction == "D"){

            }
        }
    }
    public void ChoseDice(){

    }
    public Boolean Reroll(){
        return Boolean.TRUE;

    }
}