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
    public void the_first_pop_question_added_by_constructor_could_be_removed() {
        // Act, Assert
        assertEquals("Pop Question 0", questionMaker.removeFirstPopQuestion());
    }

    @Test
    public void the_first_science_question_added_by_constructor_could_be_removed() {
        // Act, Assert
        assertEquals("Science Question 0", questionMaker.removeFirstScienceQuestion());
    }

    @Test
    public void the_first_sports_question_added_by_constructor_could_be_removed() {
        // Act, Assert
        assertEquals("Sports Question 0", questionMaker.removeFirstSportsQuestion());
    }

    @Test
    public void the_first_rock_question_added_by_constructor_could_be_removed() {
        // Act, Assert
        assertEquals("Rock Question 0", questionMaker.removeFirstRockQuestion());
    }

}
