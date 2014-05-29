package kata.trivia;

/**
 * Created by benwu on 14-5-28.
 */
public class Player {
    public static final int MAX_NUMBER_OF_PLACE = 12;
    public static final int CATEGORY_POP_1 = 0;
    public static final int CATEGORY_POP_2 = 4;
    public static final int CATEGORY_POP_3 = 8;
    public static final int CATEGORY_SCIENCE_1 = 1;
    public static final int CATEGORY_SCIENCE_2 = 5;
    public static final int CATEGORY_SCIENCE_3 = 9;
    public static final int CATEGORY_SPORTS_1 = 2;
    public static final int CATEGORY_SPORTS_2 = 6;
    public static final int CATEGORY_SPORTS_3 = 10;
    public static final String POP = "Pop";
    public static final String SCIENCE = "Science";
    public static final String SPORTS = "Sports";
    public static final String ROCK = "Rock";
    private String playerName;
    private int place = 0;
    private int sumOfGoldCoins = 0;
    private boolean isInPenaltyBox = false;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return this.playerName;
    }

    public void moveForwardSteps(int steps) {
        this.place += steps;
        if (this.place > MAX_NUMBER_OF_PLACE - 1) this.place -= MAX_NUMBER_OF_PLACE;
    }

    public int getPlace() {
        return this.place;
    }

    public String getCurrentCategory() {
        if (this.place == CATEGORY_POP_1) return POP;
        if (this.place == CATEGORY_POP_2) return POP;
        if (this.place == CATEGORY_POP_3) return POP;
        if (this.place == CATEGORY_SCIENCE_1) return SCIENCE;
        if (this.place == CATEGORY_SCIENCE_2) return SCIENCE;
        if (this.place == CATEGORY_SCIENCE_3) return SCIENCE;
        if (this.place == CATEGORY_SPORTS_1) return SPORTS;
        if (this.place == CATEGORY_SPORTS_2) return SPORTS;
        if (this.place == CATEGORY_SPORTS_3) return SPORTS;
        return ROCK;
    }

    public void winAGoldCoin() {
        this.sumOfGoldCoins++;
    }

    public int countGoldCoins() {
        return this.sumOfGoldCoins;
    }

    public boolean isInPenaltyBox() {
        return this.isInPenaltyBox;
    }

    public void getOutOfPenaltyBox() {
        this.isInPenaltyBox = false;
    }

    public void sentToPenaltyBox() {
        this.isInPenaltyBox = true;
    }
}
