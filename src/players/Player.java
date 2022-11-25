package players;

import java.util.Objects;

public class Player implements Comparable<Player>{
    public final String name;
    private int score;

    public Player(String name) {
    this.name = name;
    score = 0;
    }
    public int hashCode(){
        return Objects.hash(this.name);
    }
    public boolean equals(Player otherPlayer){
        return otherPlayer.name.equals(this.name);
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
