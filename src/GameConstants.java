public enum GameConstants {
    minAllowedPlayers(2),
    maxAllowedPlayers(4),
    maxAllowedNameLength(20);

    public final int definedConstant;
    GameConstants(Integer definedConstant) {
        this.definedConstant = definedConstant;
    }
}
