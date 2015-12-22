import java.util.Iterator;

/**
 * Tic Tac Toe - Board
 * Board Size :  N * N - 3 to 8.
 * Instead of character Array , i created Something called as Cell. Nothing else
 * It's just yet another board by now
 */
public class Board {

//    I love to write comments then and there.
//    Properties
    private Integer boardSize;
    private Cell[][] cell;

    public Board(Integer size){
        boardSize = size;
        cell = new Cell[boardSize][boardSize];

//      Create as many instances
        for (int i= 0; i < boardSize; ++i){
            for (int j=0; j < boardSize; ++j){
                cell[i][j] = new Cell(i,j);
            }
        }
    }

    public boolean makeMyMove(Integer row,Integer col){
        Cell currentCell = cell[row][col];
        return currentCell.setValue('X');
    }

    public boolean makeHisMove(Integer row, Integer col){
        Cell currentCell = cell[row][col];
        return currentCell.setValue('O');
    }

//  All the comments now present will be removed in final Production ready code
    public Cell getCell(Integer row, Integer col){
        return cell[row][col];
    }

//  iterator for all cells in the board
    public Iterator iterator(){
        return new BoardIterator(cell);
    }

    public int size() {
        return boardSize*boardSize;
    }

    //  Not sure if this is how Iterator should be implemented for a Class
//  Just using it as it is.
    private class BoardIterator implements Iterator{

        private  Cell[][] cell;
        private  Integer row;
        private  Integer col;

        public BoardIterator(Cell[][] cell){
            this.cell  = cell;
        }

        public boolean hasNext() {
            if (col == boardSize && row < boardSize-1 ){
                col = 0;
                row++;
            }

            return (row < boardSize && col < boardSize);
        }

        public Cell next() {
            return cell[row][col++];
        }
    }
}
