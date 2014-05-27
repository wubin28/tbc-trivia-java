package kata.trivia;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {

    @Test
    public void the_game_should_be_over_if_a_player_rolls_the_dice_and_answers_each_question_correctly_for_6_times() {

        // Arrange
        Game game = new Game();
        game.add("Chet");
        boolean isGameStillInProgress = true;

        // Act
        for (int i = 0; i < 6; i++) {
            game.roll(1);
            isGameStillInProgress = game.wasCorrectlyAnswered();
        }

        // Assert
        assertFalse(isGameStillInProgress);
    }

    // TODO-acceptance-test: the game should be over if a player rolls the dice for 7 times and answers the question wrongly for 1 time followed by an odd rolling number but then correctly for 6 times
    // TODO-acceptance-test: the game should be over if a player rolls the dice for 8 times and answers the question wrongly for 1 time followed by an even rolling number but then correctly for 7 times
}
