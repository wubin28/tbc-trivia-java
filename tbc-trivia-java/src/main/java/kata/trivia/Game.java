package kata.trivia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Game {
    private final QuestionMaker questionMaker = new QuestionMaker();

    private ArrayList<Player> players = new ArrayList<Player>();

    // TODO-working-on: Move inPenaltyBox into class Player
    private boolean[] inPenaltyBox = new boolean[6];

    private int currentPlayer = 0;
    private boolean isGettingOutOfPenaltyBox;

    private static Logger logger = Logger.getLogger("kata.trivia.Game");
    private static FileHandler fileHandler = null;

    public Game() {
        try {
            fileHandler = new FileHandler("%h/Game-logging.log", 10000000, 1, true);
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fileHandler);

        for (int i = 0; i < 50; i++) {
            questionMaker.addPopQuestion("Pop Question " + i);
            questionMaker.addScienceQuestion(("Science Question " + i));
            questionMaker.addSportsQuestion(("Sports Question " + i));
            questionMaker.addRockQuestion("Rock Question " + i);
        }
    }

    public void add(String playerName) {

        players.add(new Player(playerName));

        logger.info(playerName + " was added");
        logger.info("The total amount of players is " + players.size());
    }

    private int howManyPlayers() {
        return players.size();
    }

    public void roll(int rollingNumber) {
        logger.info(players.get(currentPlayer) + " is the current player");
        logger.info("They have rolled a " + rollingNumber);

        if (inPenaltyBox[currentPlayer]) {
            if (rollingNumber % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                logger.info(players.get(currentPlayer) + " is getting out of the penalty box");
                currentPlayerMovesToNewPlaceAndAnswersAQuestion(rollingNumber);
            } else {
                logger.info(players.get(currentPlayer) + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {
            currentPlayerMovesToNewPlaceAndAnswersAQuestion(rollingNumber);
        }

    }

    private void currentPlayerMovesToNewPlaceAndAnswersAQuestion(int rollingNumber) {
        players.get(currentPlayer).moveForwardSteps(rollingNumber);

        logger.info(players.get(currentPlayer)
                + "'s new location is "
                + players.get(currentPlayer).getPlace());
        logger.info("The category is " + players.get(currentPlayer).getCurrentCategory());
        askQuestion();
    }

    private void askQuestion() {
        if (players.get(currentPlayer).getCurrentCategory() == "Pop")
            logger.info(questionMaker.removeFirstPopQuestion());
        if (players.get(currentPlayer).getCurrentCategory() == "Science")
            logger.info(questionMaker.removeFirstScienceQuestion());
        if (players.get(currentPlayer).getCurrentCategory() == "Sports")
            logger.info(questionMaker.removeFirstSportsQuestion());
        if (players.get(currentPlayer).getCurrentCategory() == "Rock")
            logger.info(questionMaker.removeFirstRockQuestion());
    }

    public boolean wasCorrectlyAnswered() {
        if (inPenaltyBox[currentPlayer]) {
            if (isGettingOutOfPenaltyBox) {
                return currentPlayerGetsAGoldCoinAndSelectNextPlayer();
            } else {
                nextPlayer();
                return true;
            }
        } else {
            return currentPlayerGetsAGoldCoinAndSelectNextPlayer();
        }
    }

    private boolean currentPlayerGetsAGoldCoinAndSelectNextPlayer() {
        logger.info("Answer was correct!!!!");
        players.get(currentPlayer).winAGoldCoin();

        logger.info(players.get(currentPlayer)
                + " now has "
                + players.get(currentPlayer).countGoldCoins()
                + " Gold Coins.");

        boolean isGameStillInProgress = isGameStillInProgress();
        nextPlayer();

        return isGameStillInProgress;
    }

    private void nextPlayer() {
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
    }

    public boolean wrongAnswer() {
        logger.info("Question was incorrectly answered");
        logger.info(players.get(currentPlayer) + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;

        nextPlayer();
        // TODO-later: The return value of method Game.wrongAnswer() is unnecessary and should be eliminated
        return true;
    }

    // TODO: The magic number 6
    private boolean isGameStillInProgress() {
        return !(players.get(currentPlayer).countGoldCoins() == 6);
    }
}
