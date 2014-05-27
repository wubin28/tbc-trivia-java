package kata.trivia;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {

    // TODO-working-on: Write characterization test
    @Test
    public void what_if_method_wasCorrectlyAnswered_of_class_Game_is_called() {

        // Assert
        boolean isGameStillInProgress = game.wasCorrectlyAnswered();
        assertTrue(isGameStillInProgress);
    }

    // TODO-acceptance-test: the game should be over if a player rolls the dice and answers each question correctly for 6 times
    // TODO-acceptance-test: the game should be over if a player rolls the dice for 7 times and answers the question wrongly for 1 time followed by an odd rolling number but then correctly for 6 times
    // TODO-acceptance-test: the game should be over if a player rolls the dice for 8 times and answers the question wrongly for 1 time followed by an even rolling number but then correctly for 7 times
}
