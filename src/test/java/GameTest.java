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

//      Playing the game without using play method. Since it is user driver, Let's test it seperately
//      I understand, the Game class might have some rework. - I want to see the game in action
//      then I'll work in it to Refactor and proper design

        game.getBoard().makeHisMove(0,0);

        assertThat(game.isOver(),is(false));
        assertThat(game.isBotWinner(),is(false));

//      Making Human as winner and check
        game.getBoard().makeHisMove(0,1);
        game.getBoard().makeHisMove(0,2);

        assertThat(game.isOver(),is(true));
        assertThat(game.isWinnerPresent(),is(true));
//        assertThat(game.isBotWinner(),is(false));
//        assertThat(game.isHumanWinner(),is(true));

//     Use winner method to get the winner of the game
        assertThat(game.winner(),is(human)); // it passed again without using equals method.
    }

}