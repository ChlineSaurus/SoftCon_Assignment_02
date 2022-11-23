package Turn;

import exceptions.IllegalUserInputExeption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class HumanInteractionManager {
    private String indices;
    private String nextAction;
    private final String possibleNextAction = "RD";
    private final String possibleIndices = "123456";
    private Boolean validInput = Boolean.FALSE;
    private final Scanner scanner;

    public HumanInteractionManager() {
        scanner = new Scanner(System.in);
    }

    private String takeInput() {
        return scanner.nextLine();
    }

    public void DisplayOrRoll() throws IllegalUserInputExeption {

        {
            System.out.println("For displaying your score please enter \"D\" for rolling the Dice please enter \"R\"");
            validInput = Boolean.FALSE;
            while (validInput != Boolean.TRUE) {
                nextAction = takeInput();
                nextAction = nextAction.toUpperCase();
                try {
                    if (!(nextAction.length() < 2 && possibleNextAction.contains(nextAction))) {
                        throw new IllegalUserInputExeption(" You only have to enter \"D\" for displaying your score OR \"R\" for rolling the dice!");
                    } else {
                        validInput = Boolean.TRUE;
                    }
                } catch (IllegalUserInputExeption e) {
                    System.out.println(" You only have to enter \"D\" for displaying your score OR \"R\" for rolling the dice!");
                }
            }


        }
        //why doesn't it execute??
        if (nextAction == "D") {
            int score = 23;
            String stringToDisplay = String.format("Your score is: %i", score);
            System.out.println(stringToDisplay);
            DisplayOrRoll();
        }

    }
// different checks: Check for duplicate, check for not valid input
    public String ChoseDice() throws IOException {
        System.out.println("Please enter the index of the Dice you want to pick. It is possible to enter multiple at a time. If you do not want to take any more dice type no");
        validInput = Boolean.FALSE;
        while (validInput != Boolean.TRUE) {
            indices = takeInput();
            try {
                for (int i = 0; i < indices.length(); i++) {
                    System.out.println(indices.charAt(i));
                    String indiceAtI = String.valueOf(indices.charAt(i));
                    //only indices from one to six
                    if (!(possibleIndices.contains(indiceAtI))) {
                        throw new IllegalUserInputExeption("your input is ass");
                }
                char charArrayIndices [] = indices.toCharArray();
                    Arrays.sort(charArrayIndices);
                    for(int j = 1; j<charArrayIndices.length; j++){
                        if(charArrayIndices[j-1] == charArrayIndices[j]){
                            throw new IllegalUserInputExeption("You can't hava dublicates...");
                        }
                    }
                }
            } catch (IllegalUserInputExeption g) {
                    System.out.println("False input, please enter all the indices of the dices you want to pick. You can pick also more than one. Please enter only the numbers and not any other character. P.S you only have six dice...");
            }

        }
        //why doesn't it go further??
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
