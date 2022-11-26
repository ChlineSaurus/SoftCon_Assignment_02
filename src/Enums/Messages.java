package Enums;

public enum Messages {
    //Setup Enums.Messages
    setUpInstruction(String.format("You may play with %2d to %2d Players: Please enter a name if you want to add a " +
            "Player. If you want to start press Enter!", GameConstants.minAllowedPlayers.definedConstant,
            GameConstants.maxAllowedPlayers.definedConstant)),
    playerNameInputToSmall("Your Player name was to long. Please give a smaller Input"),
    necessaryPointsQuestion("Until how many Points do you want to play the game? Please enter a Number"),
    notEnoughPlayer("You currently dont have enough players"),

    stopOrContinueQuestion("Enter 's' if you want to stop or 'c' if you want to continue: "),

    //Input Exceptions
    illegalCharException("You input contained other symbols than numbers, spaces and commas. Please give a valid Input"),
    notANumberException("You input contained other symbols than numbers. Please give a valid Input"),
    notACharException("You were supposed to input a single char, but your input was not of length one"),
    notAllowedCommandException("Your gave a Character as Input for which no command exists. Please give a valid Input"),
    notAllowedNumberException("Your input contained numbers that are not on a six faced Dice. Please give a valid Input."),
    noDiceTakenException("Your input had length zero. Please give a valid Input."),
    toManyDiceTakenException("Your wanted to take more dices than you are currently not taken. Please give a valid Input."),
    notExistingDiceTakenException("You wanted to take a dice, that doesn't exist. Please give a valid Input");

    public final String message;
    Messages(String message) {
        this.message = message;
    }


}
