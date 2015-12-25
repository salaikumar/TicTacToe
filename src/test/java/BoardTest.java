import org.junit.Test;

import java.util.ArrayList;

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

        Cell freecell = board.nextFreePosition();
        Cell expected = new Cell(0,0);
        assertThat(freecell.equals(expected),is(true));

    }

    /*
     * Creates a new Board. Set values to all the Cells
     * Check row by row that the rows are as expected
     */
    @Test
    public void shouldTestReadEnums() {

        Board board = new Board(3);

//      Fill the board completely. Do one final round of testing for other methods as well
        board.makeMyMove(0,1);
        assertThat(board.makeHisMove(0, 1), is(false));
        board.makeHisMove(0,0);
        board.makeMyMove(1,1);
        board.makeHisMove(2, 1);
        assertThat(board.makeMyMove(2,1),is(false));

//      Check if board is full;
        assertThat(board.isFull(),is(false));

        board.makeMyMove(2,0);
        board.makeHisMove(0,2);

        board.makeMyMove(1,0);
        board.makeHisMove(1, 2);
        board.makeMyMove(2,2);

        assertThat(board.isFull(),is(true));

//     Create a row similar to Row 1 and check for Equality
        ArrayList<Cell> expectedRow = new ArrayList<Cell>(3);
        expectedRow.add(new Cell(1,0,'X'));
        expectedRow.add(new Cell(1,1,'X'));
        expectedRow.add(new Cell(1,2,'O'));

        ArrayList<ArrayList<Cell>> allRows = board.getAllRows();

//       This test case is supposed to pass. But it failed. Let us find why
//       Policy : Never use Debugger
//        assertThat(allRows.get(1).equals(expectedRow),is(true));

        ArrayList<Cell> actualRow = allRows.get(1);

//       Assert each Cell by Cell values - u will know where u went wrong
        assertThat(actualRow.get(0).equals(new Cell(1,0,'X')),is(true));
        assertThat(actualRow.get(1).equals(new Cell(1,1,'O')),is(false));
        assertThat(actualRow.get(2).equals(new Cell(1,2,'O')),is(true));

        assertThat(actualRow.equals(expectedRow),is(true));


//    
    }




}