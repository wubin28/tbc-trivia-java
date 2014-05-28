package kata.trivia;

/**
 * Created by benwu on 14-5-28.
 */
public class Player {
    private String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return this.playerName;
    }

    public void moveForwardSteps(int steps) {

    }
}
