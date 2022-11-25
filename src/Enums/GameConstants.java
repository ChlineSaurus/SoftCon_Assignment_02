package Enums;

public enum GameConstants {
    minAllowedPlayers(2),
    maxAllowedPlayers(4),
    maxAllowedNameLength(20),
    minAllowedPoints(1000),
    maxAllowedPoints(50000);

    public final int definedConstant;
    GameConstants(Integer definedConstant) {
        this.definedConstant = definedConstant;
    }
}
