package cards.cards.cardtypes;

import cards.AbstractCard;

public class Cloverleaf extends AbstractCard {
    private final String name="Cloverleaf";
    int TuttoRequiredForPoints = 2;
    boolean EndTurn = false;
    boolean KeepAllValidDice = false;
    boolean Immunity = false;
    boolean EndGame = true;
    int TuttoRequiredForBonus = 2;
}
