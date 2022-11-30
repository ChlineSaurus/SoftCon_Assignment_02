package cards.cards.cardInterfaces.bonusSystemInterface;

public class PlusPoints implements  BonusSystem{
    public int bonusPoints(int bonusPoints,int currentPoints) {
        return currentPoints + bonusPoints;
    }
}
