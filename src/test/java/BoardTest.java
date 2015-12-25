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
     * Check the Read only Enum or Non Destructive Enum Operations on Board Class
     * Methods Tested: getAllRows, getAllColumns, getDiagonals
     */
    @Test
    public void shouldTestReadEnums() {

        Board board = new Board(3);
        board.makeMyMove(0,1);
        assertThat(board.makeHisMove(0, 1), is(false));
        board.makeHisMove(0,0);
        board.makeMyMove(1,1);
        board.makeHisMove(2, 1);
        assertThat(board.makeMyMove(2,1),is(false));
        assertThat(board.isFull(),is(false));
        board.makeMyMove(2,0);
        board.makeHisMove(0,2);
        board.makeMyMove(1,0);
        board.makeHisMove(1, 2);
        board.makeMyMove(2,2);
        assertThat(board.isFull(),is(true));

        /*
         * getAllRows Test
         */
        ArrayList<Cell> expectedRow = new ArrayList<Cell>(3);
        expectedRow.add(new Cell(1,0,'X'));
        expectedRow.add(new Cell(1,1,'X'));
        expectedRow.add(new Cell(1,2,'O'));
        ArrayList<ArrayList<Cell>> allRows = board.getAllRows();
        ArrayList<Cell> actualRow = allRows.get(1);
        assertThat(actualRow.equals(expectedRow),is(true));


        /*
         * getAllColumns Test
         */
        ArrayList<Cell> actualColumn = board.getAllColumns().get(0);
        ArrayList<Cell> expectedColumn = new ArrayList<Cell>(3);
        expectedColumn.add(new Cell(0,0,'O'));
        expectedColumn.add(new Cell(1,0,'X'));
        expectedColumn.add(new Cell(2,0,'X'));
        assertThat(actualColumn.equals(expectedColumn),is(true));


        /*
         * getDiagonals Test
         */
        ArrayList<Cell> actualDiagonal =  board.getDiagonals().get(1);
        ArrayList<Cell> expectedDiagonal = new ArrayList<Cell>();
        expectedDiagonal.add(new Cell(0,2,'O'));
        expectedDiagonal.add(new Cell(1,1,'X'));
        expectedDiagonal.add(new Cell(2,0,'X'));
        assertThat(actualDiagonal.equals(expectedDiagonal),is(true));

    }




}