package kata.trivia;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by benwu on 14-5-29.
 */
public class QuestionMakerTest {
    public static final String POP_QUESTION_1 = "Pop Question 1";
    public static final String SCIENCE_QUESTION_1 = "Science Question 1";
    public static final String SPORTS_QUESTION_1 = "Sports Question 1";
    public static final String ROCK_QUESTION_1 = "Rock Question 1";
    private QuestionMaker questionMaker = null;

    @Before
    public void initialize() {
        // Arrange
        questionMaker = new QuestionMaker();
    }

    @Test
    public void add_two_pop_questions_and_could_remove_the_first_one() {
        // Act
        // TODO: Extract variable
        questionMaker.addPopQuestion(POP_QUESTION_1);
        questionMaker.addPopQuestion("Pop Question 2");

        // Assert
        assertEquals(POP_QUESTION_1, questionMaker.removeFirstPopQuestion());
    }

    @Test
    public void add_two_science_questions_and_could_remove_the_first_one() {
        // Act
        questionMaker.addScienceQuestion(SCIENCE_QUESTION_1);
        questionMaker.addScienceQuestion("Science Question 2");

        // Assert
        assertEquals(SCIENCE_QUESTION_1, questionMaker.removeFirstScienceQuestion());
    }

    @Test
    public void add_two_sports_questions_and_could_remove_the_first_one() {
        // Act
        questionMaker.addSportsQuestion(SPORTS_QUESTION_1);
        questionMaker.addSportsQuestion("Sports Question 2");

        // Assert
        assertEquals(SPORTS_QUESTION_1, questionMaker.removeFirstSportsQuestion());
    }

    @Test
    public void add_two_rock_questions_and_could_remove_the_first_one() {
        // Act
        questionMaker.addRockQuestion(ROCK_QUESTION_1);
        questionMaker.addRockQuestion("Rock Question 2");

        // Assert
        assertEquals(ROCK_QUESTION_1, questionMaker.removeFirstRockQuestion());
    }

}
