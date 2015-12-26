import java.util.ArrayList;
import java.util.Iterator;

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
            return ((row < boardSize) && (col < boardSize));
        }
        public Cell next() {
            return cell[row][col++];
        }
    }


}
