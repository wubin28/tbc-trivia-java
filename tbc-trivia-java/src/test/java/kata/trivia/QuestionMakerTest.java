package kata.trivia;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by benwu on 14-5-29.
 */
public class QuestionMakerTest {
    private QuestionMaker questionMaker = null;

    @Before
    public void initialize() {
        // Arrange
        questionMaker = new QuestionMaker();
    }

    @Test
    public void add_two_pop_questions_and_could_remove_the_first_one() {
        // Act
        questionMaker.addPopQuestion("Pop Question 1");
        questionMaker.addPopQuestion("Pop Question 2");

        // Assert
        assertEquals("Pop Question 1", questionMaker.removeFirstPopQuestion());
    }

    @Test
    public void add_two_science_questions_and_could_remove_the_first_one() {
        // Act
        questionMaker.addScienceQuestion("Science Question 1");
        questionMaker.addScienceQuestion("Science Question 2");

        // Assert
        assertEquals("Science Question 1", questionMaker.removeFirstScienceQuestion());
    }

    @Test
    public void add_two_sports_questions_and_could_remove_the_first_one() {
        // Act
        questionMaker.addSportsQuestion("Sports Question 1");
        questionMaker.addSportsQuestion("Sports Question 2");

        // Assert
        assertEquals("Sports Question 1", questionMaker.removeFirstSportsQuestion());
    }

    @Test
    public void add_two_rock_questions_and_could_remove_the_first_one() {
        // Act
        questionMaker.addRockQuestion("Rock Question 1");
        questionMaker.addRockQuestion("Rock Question 2");

        // Assert
        assertEquals("Rock Question 1", questionMaker.removeFirstRockQuestion());
    }

}
