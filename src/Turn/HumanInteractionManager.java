package Turn;

import Input.TuttoInput;
import dice.DiceFace;
import exceptions.IllegalUserInputExeption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HumanInteractionManager {
    private ArrayList<DiceFace> indices;
    private Character nextAction;
    private Boolean validInput = Boolean.FALSE;
    private final ArrayList<Character> possibleNextAction;

    public HumanInteractionManager() {
        possibleNextAction = new ArrayList<Character>();
        possibleNextAction.add('R');
        possibleNextAction.add('D');
    }
    public void DisplayOrRoll() throws IllegalUserInputExeption {
        {
            System.out.println("For displaying your score please enter \"D\" for rolling the Dice please enter \"R\"");
            validInput = Boolean.FALSE;
            while (validInput != Boolean.TRUE) {

                try {
                    nextAction = TuttoInput.takeRestrictedCharInput(possibleNextAction);
                } catch (IllegalUserInputExeption e) {
                    //Sött eingentli nüt da usgeh werde, das chan mer denn em UI überlah
                    System.out.println(e.getMessage());
                }
                validInput = Boolean.TRUE;
            }
        }
        //why doesn't it execute??
        if (nextAction.equals('D')) {
            //Call UI
            System.out.println("here should the call to the UI be displayed...");
            DisplayOrRoll();
        }
    }
// different checks: Check for duplicate, check for not valid input
    public ArrayList<DiceFace> ChoseDice() {
        System.out.println("Please enter the Values of the Dices you want to pick. It is possible to enter multiple at a time. If you do not want to take any more dice type E");
        validInput = Boolean.FALSE;
        while (validInput == Boolean.FALSE) {
            try {
                indices = TuttoInput.takeDiceListInput();
            } catch (IllegalUserInputExeption e) {
                System.out.println(e.getMessage());
            }
            validInput = Boolean.TRUE;
        }

        return indices;
    }
        public Boolean Reroll() throws IOException {
            {
                BufferedReader inputReader = new BufferedReader(
                        new InputStreamReader(System.in)
                );

                System.out.println("You have no valid dice. To see the dice enter \"D\" to reroll the dice \"R\" and if you want to end your turn \"E\"");
                String nextAction = inputReader.readLine();
                System.out.println(nextAction);
            }
            return Boolean.FALSE;

        }
    }
