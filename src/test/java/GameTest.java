import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Game Test Class
 */
public class GameTest {

    @Test
    public void shouldTestGettersSetters() {
        Game game = new Game();

//       Create two players
         Player human = new Player("Salaikumar",'O');
         Player bot   = new Player("Ashwathama" ,'X');
         bot.makeBot();

//       Set players
         game.setBot(bot);
         game.setHuman(human);

//       Create one board
         Board board = new Board(3);
         game.setBoard(board);


//       Check if the getters return the same board and players
//       Is this right?
//       Technically i should be using equals method of these objects to compare.
         assertThat(game.getBoard(),is(board));
         assertThat(game.getHuman(),is(human));
         assertThat(game.getBot(),is(bot));

         Player falseBot = new Player("Saravanan",'Y');
         falseBot.makeBot();
         assertThat(game.getBot().equals(falseBot),is(false));


    }
}