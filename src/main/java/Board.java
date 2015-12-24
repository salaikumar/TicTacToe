import java.util.ArrayList;
import java.util.Iterator;

/**
 * Tic Tac Toe - Board
 * Board Size :  N * N - 3 to 8.
 * Instead of character Array , i created Something called as Cell. Nothing else
 * It's just yet another board by now
 */

/*
 * Assumption - Board Indexes Start from 0,0. Assumed the row and col value is passed as such.
 * Assume if for user, board index starts at 1,1, we don't handle it here
 * It should be handled in another place. not here. -- yes, by now that's it
 * And yes, I love giving empty lines in my code. it makes it more legible for me.
 *
 * Win or Lose Decisions.
 * Those methods are also implemented over here. I don't know if that is right or wrong as per S/W Engg. policy
 * Since the board is here, at this class, I feel it is better to write it over here
 */
public class Board {

    private Integer boardSize;
    private Cell[][] cell;

    public Board(Integer size){

        boardSize = size ;
        cell = new Cell[boardSize][boardSize];

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

    public Cell getCell(Integer row, Integer col){
        return cell[row][col];
    }

    public int size() {
        return boardSize;
    }


//  Get an Empty position
//  By now, Let the bot lack Intelligence. Just get the next free position and return.
//  Is there a better way to do it?
//  Will using Random function add an advantage?
//  This takes n*n time;
//  You can keep track of free positions and return any one from it. -- Later implementation

    public Cell nextFreePosition(){

        for (int i=0; i < boardSize; ++i){
            for (int j =0 ; j < boardSize ; ++j){
                Cell freeCell = cell[i][j];
                if (!freeCell.isFilled())
                    return freeCell;
            }
        }

        return null;
    }

// Win Checks.
//  Check if board is full. - all cells are filled
//  It does take n*n time. there is no other way?
    public boolean isFull(){

        for (int i=0; i < boardSize; ++i){
            for (int j =0 ; j < boardSize ; ++j){
                Cell freeCell = cell[i][j];
                if (!freeCell.isFilled())
                    return false;
            }
        }

        return true;
    }


    /*
     * In Order to check the Game Status,
     * We need to get all rows of the board, all columns of the Board
     * or all Diagonals
     * I'm going to return a Arraylist which itself would contain Arraylist at each position.
     */

//   Why am i not able to return the list interface?
//   I should check this.

    public ArrayList<ArrayList<Cell>> getAllRows(){
        ArrayList<ArrayList<Cell>> rows = new ArrayList<ArrayList<Cell>>(boardSize);
        for (int i = 0; i < boardSize ; ++i){
            ArrayList<Cell> individualRow = new ArrayList<Cell>(boardSize);
            for (int j=0; j< boardSize ; ++j){
                individualRow.add(getCell(i,j));
            }
            rows.add(individualRow);
        }
        return rows;
    }


//   Return All columns
    public ArrayList<ArrayList<Cell>> getAllColumns(){
        ArrayList<ArrayList<Cell>> cols = new ArrayList<ArrayList<Cell>>(boardSize);
        for (int i = 0; i < boardSize ; ++i){
            ArrayList<Cell> individualCol = new ArrayList<Cell>(boardSize);
            for (int j=0; j< boardSize ; ++j){
                individualCol.add(getCell(j,i));
            }
            cols.add(individualCol);
        }
        return cols;
    }

//   Return the 2 diagonals
    public ArrayList<ArrayList<Cell>> getDiagonals(){
        ArrayList<ArrayList<Cell>> diagonals = new ArrayList<ArrayList<Cell>>(2);

        ArrayList<Cell> diagonalOne = new ArrayList<Cell>();
        for (int i= 0, j= 0; i < boardSize && j <boardSize; ++i,++j)
            diagonalOne.add(getCell(i,j));
        diagonals.add(diagonalOne);

        ArrayList<Cell> diagonalTwo = new ArrayList<Cell>();
        for (int i= 0, j= boardSize-1; i < boardSize && j <boardSize; ++i,--j)
            diagonalTwo.add(getCell(i,j));
        diagonals.add(diagonalTwo);

        return diagonals;
    }

    /*
     * Iterator Implementation
     */
    public Iterator iterator(){
        return new BoardIterator(cell);
    }

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
