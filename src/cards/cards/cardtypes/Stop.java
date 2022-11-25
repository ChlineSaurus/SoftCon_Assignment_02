package cards.cards.cardtypes;


public class Stop extends AbstractCard {
    private final String name="Stop";
    int TuttoRequiredForPoints = 0;
    boolean EndTurn = true;
    boolean KeepAllValidDice = false;
    boolean Immunity = false;
    boolean EndGame = false;
    int TuttoRequiredForBonus = 0;
}
