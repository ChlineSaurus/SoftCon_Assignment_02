package cards.cards.cardInterfaces.bonusSystemInterface;

public class DeductPoints implements BonusSystem {
    public int bonusPoints(int points) {
        return -points;
    }
}