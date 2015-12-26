import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test Cases for Player class
 */
public class PlayerTest {

    /*
     * Create an Player instance
     * Get its name and value
     */
    @Test
    public void shouldTestPlayerClass() {

        Player player = new Player("Salaikumar", 'X');
        assertThat(player.getCellValue(),is('X'));
        assertThat(player.getPlayerName(),is("Salaikumar"));

        assertThat(player.isBot(),is(false));
        player.makeBot();
        assertThat(player.isBot(),is(true));
    }
}