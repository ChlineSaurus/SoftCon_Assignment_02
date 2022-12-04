package Enums;

public enum Msg {
    //Setup Enums.Messages
    setUpInstruction(String.format("You may play with %2d to %2d Players: Please enter a name if you want to add a " +
            "Player. If you want to start press Enter twice!", GameConstants.minAllowedPlayers.definedConstant,
            GameConstants.maxAllowedPlayers.definedConstant)),
    playerNameInputToSmall("Your Player name was to long. Please give a smaller Input"),
    necessaryPointsQuestion("Until how many Points do you want to play the game? Please enter a Number between "+GameConstants.minAllowedPoints.definedConstant +
            " and "+ GameConstants.maxAllowedPoints.definedConstant+ ":"),
    notEnoughPlayer("You currently dont have enough players"),
    pointInputOutOfBounds("The minimum necessary points are "
            + GameConstants.minAllowedPoints.definedConstant + " the maximum are " + GameConstants.maxAllowedPoints.definedConstant),
    takeAtLeastOneValidDice("You can't exit, you must take at least one Dice"),
    explainHowToTakeDice("Please enter the dice you want to take, example: if you want take a one and five enter '15' or'51'"),

    //Input Exceptions
    illegalCharException("You input contained other symbols than numbers, spaces and commas. Please give a valid Input"),
    notANumberException("You input contained other symbols than numbers. Please give a valid Input"),
    notACharException("You were supposed to input a single char, but your input was not of length one"),
    notAllowedCommandException("Your gave a Character as Input for which no command exists. Please give a valid Input"),
    notAllowedNumberException("Your input contained numbers that are not on a six faced Dice. Please give a valid Input."),
    noDiceTakenException("Your input had length zero. Please give a valid Input."),
    nullRoll("You rolled a Null :( "),
    toManyDiceTakenException("Your wanted to take more dices than you are currently not taken. Please give a valid Input."),
    notExistingDiceTakenException("You wanted to take a dice, that doesn't exist. Please give a valid Input"),
    notAllowedDiceInInput("Make sure that only take valid dice, read the description to see if any special rules apply: "),
    notAllowedToTakePoints("If you end your turn now, you'll receive zero points, roll again!, type \"R\""),

    //Turn Interaction Messages
    tuttoAndCloverleafOrFireworks("You have a tutto but you must go on."),
    stopOrContinueQuestion("Enter \"S\" if you want to stop or \"R\" if you want to continue: "),
    announceNextPlayer("Your turn is over, the next player is: "),
    decoration("\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+-+-+-+-+-+-" +
            "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n"),
    displayOrRollQuestion("For displaying your score please enter \"D\" for rolling the Dice please enter \"R\""),
    endOrRollQuestion("Enter to reroll the dice \"R\" and if you want to end your turn \"E\""),
    standardRollQuestion("If you want to take more Dice enter the Numbers, else press Enter");


    public final String message;
    Msg(String message) {
        this.message = message;
    }
}
