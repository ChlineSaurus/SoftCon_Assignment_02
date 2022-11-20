package cards.cards.cardInterfaces.bonusSystemInterface;

public class TimesXPoints implements BonusSystem{
    @Override
    public int bonusPoints(int points) {
        return points*2;
    }
}
