package cards.cards.cardInterfaces.bonusSystemInterface;

public class DeductPoints implements BonusSystem {
    public int bonusPoints(int bonusPoints,int currentPoints) {
        return -bonusPoints;
    }
}
