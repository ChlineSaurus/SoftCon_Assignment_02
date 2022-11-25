package Turn;

import UI.Display;

public class Terminate {

    public Terminate() {
    }

    public int calculateOverWin() {
        //Call Function in Player to calculate Ammount over the threshold. It should return the Players Name and its Score...
        String winnermessage = "This is my big winner announcement";
        Display.displayMessage(winnermessage);
        return 3;
    }
}

