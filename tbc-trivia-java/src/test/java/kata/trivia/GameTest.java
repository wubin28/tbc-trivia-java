package kata.trivia;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GameTest {

    private Game game = null;
    private boolean isGameStillInProgress = true;

    @Before
    public void initialize() {
        // Arrange
        game = new Game();
        game.add("Chet");
        isGameStillInProgress = true;
    }

    @Test
    public void the_game_should_be_over_if_a_player_rolls_the_dice_and_answers_each_question_correctly_for_6_times() {
        // Act
        for (int i = 0; i < 6; i++) {
            game.roll(1);
            isGameStillInProgress = game.wasCorrectlyAnswered();
        }

        // Assert
        assertFalse(isGameStillInProgress);
    }

    @Test
    public void the_game_should_be_over_if_a_player_rolls_the_dice_for_7_times_and_answers_the_question_wrongly_for_1_time_followed_by_a_rolling_number_which_is_not_4_but_then_correctly_for_6_times() {
        // Act
        game.roll(1);
        game.wrongAnswer();
        game.roll(6);
        game.wasCorrectlyAnswered();
        for (int i = 0; i < 5; i++) {
            game.roll(1);
            isGameStillInProgress = game.wasCorrectlyAnswered();
        }

        // Assert
        assertFalse(isGameStillInProgress);
    }

    @Test
    public void the_game_should_be_over_if_a_player_rolls_the_dice_for_8_times_and_answers_the_question_wrongly_for_1_time_followed_by_a_rolling_number_which_is_4_but_then_correctly_for_7_times_with_odd_rolling_numbers() {
        // Act
        game.roll(1);
        game.wrongAnswer();
        game.roll(4);
        game.wasCorrectlyAnswered();
        for (int i = 0; i < 6; i++) {
            game.roll(1);
            isGameStillInProgress = game.wasCorrectlyAnswered();
        }

        // Assert
        assertFalse(isGameStillInProgress);
    }
}
