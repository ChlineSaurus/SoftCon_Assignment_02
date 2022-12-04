package players;

public class Player implements Comparable<Player>{

    public final String name;
    private int score;

    public Player(String name) {
    this.name = name;
    score = 0;
    }

    public void updateScore(int pointsToAdd) {
        score += pointsToAdd;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Player otherPlayer) {
        return this.name.compareTo(otherPlayer.name);
    }
}
