import java.util.Iterator;

/**
 * Tic Tac Toe - Board
 * Board Size :  N * N - 3 to 8.
 */
public class Board {

    private Integer boardSize;
    private Cell[] cell;

    public Board(Integer size){
        boardSize = size;
        cell = new Cell[boardSize * boardSize];

//      Create as many instances
        for (int i= 0; i < boardSize; ++i){
            for (int j=0; j < boardSize; ++j){
                cell[(i*boardSize)+j] = new Cell(i,j);
            }
        }
    }

    public boolean makeMyMove(Integer row,Integer col){
        Cell currentCell = cell[getCellIndex(row,col)];
        return currentCell.setValue('X');
    }

    public boolean makeHisMove(Integer row, Integer col){
        Cell currentCell = cell[getCellIndex(row,col)];
        return currentCell.setValue('O');
    }

    private Integer getCellIndex(Integer row, Integer col) {
        return ((row-1 * boardSize) + col-1);
    }

//  iterator for all cells in the board
    public Iterator iterator(){
        return new BoardIterator(cell);
    }

//  Not sure if this is how Iterator should be implemented for a Class
//  Just using it as it is.
    private class BoardIterator implements Iterator{

        private  Cell[] cell;
        private  Integer currentIndex;

        public BoardIterator(Cell[] cell){
            this.cell  = cell;
            currentIndex = 0; // is this right? what is the default value of Integer
        }

        public boolean hasNext() {
            return currentIndex < boardSize * boardSize;
        }

        public Cell next() {
            return cell[currentIndex++];
        }
    }
}
