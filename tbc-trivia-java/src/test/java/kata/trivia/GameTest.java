package kata.trivia;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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

    @Test
    public void the_game_should_be_over_if_a_player_rolls_the_dice_for_7_times_and_answers_the_question_wrongly_for_1_time_followed_by_an_odd_rolling_number_but_then_correctly_for_6_times() {

        // Arrange
        Game game = new Game();
        game.add("Chet");
        boolean isGameStillInProgress = true;

        // Act
        game.roll(1);
        game.wrongAnswer();
        game.roll(1);
        game.wasCorrectlyAnswered();
        for (int i = 0; i < 5; i++) {
            game.roll(1);
            isGameStillInProgress = game.wasCorrectlyAnswered();
        }

        // Assert
        assertFalse(isGameStillInProgress);
    }

    @Test
    public void the_game_should_be_over_if_a_player_rolls_the_dice_for_8_times_and_answers_the_question_wrongly_for_1_time_followed_by_an_even_rolling_number_but_then_correctly_for_7_times_with_odd_rolling_numbers() {

        // Arrange
        Game game = new Game();
        game.add("Chet");
        boolean isGameStillInProgress = true;

        // Act
        game.roll(1);
        game.wrongAnswer();
        game.roll(2);
        game.wasCorrectlyAnswered();
        for (int i = 0; i < 6; i++) {
            game.roll(1);
            isGameStillInProgress = game.wasCorrectlyAnswered();
        }

        // Assert
        assertFalse(isGameStillInProgress);
    }

    @Test
    public void the_place_should_be_1_if_the_player_moves_forward_1_step() {
        // Arrange
        Player player = new Player("Ben");

        // Act
        player.moveForwardSteps(1);

        // Assert
        assertEquals(1, player.getPlace());
    }

    @Test
    public void the_place_should_be_0_if_the_player_moves_forward_12_steps() {
        // Arrange
        Player player = new Player("Ben");

        // Act
        player.moveForwardSteps(12);

        // Assert
        assertEquals(0, player.getPlace());
    }

    @Test
    public void the_category_should_be_Pop_if_the_player_is_in_place_0_or_4_or_8() {
        // Arrange
        Player player = new Player("Ben");
        String category = "Pop";

        // Act, Assert
        player.moveForwardSteps(12);
        assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(4);
        assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(4);
        assertEquals(category, player.getCurrentCategory());
    }

    @Test
    public void the_category_should_be_Science_if_the_player_is_in_place_1_or_5_or_9() {
        // Arrange
        Player player = new Player("Ben");
        String category = "Science";

        // Act, Assert
        player.moveForwardSteps(1);
        assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(4);
        assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(4);
        assertEquals(category, player.getCurrentCategory());
    }

    @Test
    public void the_category_should_be_Sports_if_the_player_is_in_place_2_or_6_or_10() {
        // Arrange
        Player player = new Player("Ben");
        String category = "Sports";

        // Act, Assert
        player.moveForwardSteps(2);
        assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(4);
        assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(4);
        assertEquals(category, player.getCurrentCategory());
    }

    @Test
    public void the_category_should_be_Rock_if_the_player_is_in_place_3_or_7_or_11() {
        // Arrange
        Player player = new Player("Ben");
        String category = "Rock";

        // Act, Assert
        player.moveForwardSteps(3);
        assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(4);
        assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(4);
        assertEquals(category, player.getCurrentCategory());
    }
}
