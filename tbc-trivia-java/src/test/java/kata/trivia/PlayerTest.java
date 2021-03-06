package kata.trivia;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by benwu on 14-5-29.
 */
public class PlayerTest {

    private Player player = null;
    private String category = null;

    @Before
    public void initialize() {
        // Arrange
        player = new Player("Ben");
    }

    @Test
    public void the_place_should_be_1_if_the_player_moves_forward_1_step() {
        // Act
        player.moveForwardSteps(1);

        // Assert
        assertEquals(1, player.getPlace());
    }

    @Test
    public void the_place_should_be_0_if_the_player_moves_forward_12_steps() {
        // Act
        player.moveForwardSteps(12);

        // Assert
        assertEquals(0, player.getPlace());
    }

    @Test
    public void the_category_should_be_Pop_if_the_player_is_in_place_0_or_4_or_8() {
        // Arrange
        category = "Pop";

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
        category = "Science";

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
        category = "Sports";

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
        category = "Rock";

        // Act, Assert
        player.moveForwardSteps(3);
        assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(4);
        assertEquals(category, player.getCurrentCategory());

        player.moveForwardSteps(4);
        assertEquals(category, player.getCurrentCategory());
    }
}
