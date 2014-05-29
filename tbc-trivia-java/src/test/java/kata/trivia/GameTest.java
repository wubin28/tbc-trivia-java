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
    public void add_two_pop_questions_and_could_remove_the_first_one() {
        // Arrange
        QuestionMaker questionMaker = new QuestionMaker();

        // Act
        questionMaker.addPopQuestion("Pop Question 1");
        questionMaker.addPopQuestion("Pop Question 2");

        // Assert
        assertEquals("Pop Question 1", questionMaker.removeFirstPopQuestion());
    }

    @Test
    public void add_two_science_questions_and_could_remove_the_first_one() {
        // Arrange
        QuestionMaker questionMaker = new QuestionMaker();

        // Act
        questionMaker.addScienceQuestion("Science Question 1");
        questionMaker.addScienceQuestion("Science Question 2");

        // Assert
        assertEquals("Science Question 1", questionMaker.removeFirstScienceQuestion());
    }

    @Test
    public void add_two_sports_questions_and_could_remove_the_first_one() {
        // Arrange
        QuestionMaker questionMaker = new QuestionMaker();

        // Act
        questionMaker.addSportsQuestion("Sports Question 1");
        questionMaker.addSportsQuestion("Sports Question 2");

        // Assert
        assertEquals("Sports Question 1", questionMaker.removeFirstSportsQuestion());
    }

    @Test
    public void add_two_rock_questions_and_could_remove_the_first_one() {
        // Arrange
        QuestionMaker questionMaker = new QuestionMaker();

        // Act
        questionMaker.addRockQuestion("Rock Question 1");
        questionMaker.addRockQuestion("Rock Question 2");

        // Assert
        assertEquals("Rock Question 1", questionMaker.removeFirstRockQuestion());
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

    // TODO: the category should be Sports if the player is in place 2 or 6 or 10
    // TODO: the category should be Rock if the player is in place 3 or 7 or 11
}
