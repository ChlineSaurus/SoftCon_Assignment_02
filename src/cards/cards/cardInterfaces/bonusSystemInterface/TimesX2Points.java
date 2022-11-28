package cards.cards.cardInterfaces.bonusSystemInterface;

public class TimesX2Points implements BonusSystem{
    @Override
    public int bonusPoints(int bonusPoints,int currentPoints){
        return currentPoints;
    }
}
