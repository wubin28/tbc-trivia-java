package kata.trivia;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp() {
        assertEquals(5, 2 + 3);
    }

    // TODO-acceptance-test: the game should be over if a player rolls the dice and answers each question correctly for 6 times
    // TODO-acceptance-test: the game should be over if a player rolls the dice for 7 times and answers the question wrongly for 1 time followed by an odd rolling number but then correctly for 6 times
    // TODO-acceptance-test: the game should be over if a player rolls the dice for 8 times and answers the question wrongly for 1 time followed by an even rolling number but then correctly for 7 times
}
