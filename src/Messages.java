public enum Messages {
    //Setup Messages
    setUpInstruction(String.format("You may play with %2d to %2d Players: Please enter a name if you want to add a " +
            "Player. If you want to start press Enter!", GameConstants.minAllowedPlayers.definedConstant,
            GameConstants.maxAllowedPlayers.definedConstant)),
    playerNameInputToSmall("Your Player name was to long. Please give a smaller Input"),
    necessaryPointsQuestion("Until how many Points do you want to play the game? Please enter a Number"),
    notEnoughPlayer("You currently dont have enough players");



    public final String message;
    Messages(String message) {
        this.message = message;
    }


}
