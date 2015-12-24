import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test Cases for Board  Class
 */
public class BoardTest {

    @Test
    public void shouldMakeMyMove() {
//        Create a Board
          Board board = new Board(3);
          assertThat(board.makeMyMove(1,1),is(true));
          assertThat(board.makeHisMove(1, 1),is(false));
          assertThat(board.makeHisMove(0,0),is(true));
          assertThat(board.makeMyMove(0, 0),is(false));

    }

    @Test
    public void shouldGetSize() {
        Board board = new Board(3);
        assertThat(board.size(),is(3));
    }

    @Test
    public void shouldGetNextFreePosition() {
        Board board = new Board(2);
        assertThat(board.isFull(),is(false));

        board.makeMyMove(1,1);

//      Should be replaced with equals method. 
        Cell freecell = board.nextFreePosition();
        Cell expected = new Cell(0,0);
        assertThat(freecell.getRow(),is(expected.getRow()));
        assertThat(freecell.getColumn(),is(expected.getColumn()));

    }
}