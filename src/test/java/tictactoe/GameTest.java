package tictactoe;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * tictactoe.Game Test Class
 */
public class GameTest {

    @Test
    public void shouldTestGettersSetters() {
        Game game = new Game();

         Player human = new Player("Salaikumar",'O');
         Player bot   = new Player("Ashwathama" ,'X');
         bot.makeBot();

         game.setBot(bot);
         game.setHuman(human);

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

    /*
     * Check if isWinn?erPresent method is working as expected.
     * Scenario: Test in the middle of the game
     *           Make Bot winner and test
     *           Make Human winner and test
     *           Full the board and test
     */
    @Test
    public void shouldTestIsWinnerPresent() {
        Game game = new Game();
        Player human = new Player("Salaikumar",'O');
        Player bot   = new Player("Ashwathama" ,'X');
        bot.makeBot();
        game.setBot(bot);
        game.setHuman(human);
        Board board = new Board(3);
        game.setBoard(board);
        game.getBoard().makeHisMove(0,0);
        assertThat(game.isOver(),is(false));
        assertThat(game.isBotWinner(),is(false));

        game.getBoard().makeHisMove(0,1);
        game.getBoard().makeHisMove(0,2);
        assertThat(game.isOver(),is(true));
        assertThat(game.isWinnerPresent(),is(true));
        assertThat(game.winner(),is(human)); // it passed again without using equals method.
    }

    @Test(expected = Exception.class)
    public void shouldTestEndPlay() throws Exception {
        Game game = new Game();
        Player human = new Player("Salaikumar",'O');
        Player bot   = new Player("Ashwathama" ,'X');
        bot.makeBot();
        game.setBot(bot);
        game.setHuman(human);
        Board board = new Board(3);
        game.setBoard(board);

        game.endPlay();
    }

    @Test
    public void shouldTestEndPlayString() {
        Game game = new Game();
        Player human = new Player("Salaikumar",'O');
        Player bot   = new Player("Ashwathama" ,'X');
        bot.makeBot();
        game.setBot(bot);
        game.setHuman(human);
        Board board = new Board(3);
        game.setBoard(board);
        game.getBoard().makeHisMove(0,0);
        game.getBoard().makeHisMove(1,1);
        game.getBoard().makeHisMove(2,2);

        assertThat(game.isOver(),is(true));

        String expected = "END" + "\n" + "Salaikumar"+"\n" + "DIAGONAL" + "\n" +board.toString();

        try {
            assertThat(game.endPlay(),is(expected));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test (expected = Exception.class)
    public void shouldTestPlayException() throws Exception {
        Game game = new Game();
        Player human = new Player("Salaikumar",'O');
        Player bot   = new Player("Ashwathama" ,'X');
        bot.makeBot();
        game.setBot(bot);
        game.setHuman(human);
        Board board = new Board(3);
//        game.setBoard(board);  // Exception cause;

        game.play();
    }

}