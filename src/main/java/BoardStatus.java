import java.util.Iterator;

/**
 * Not sure why I move certain functionalities to this class.
 * Let's see how well we can do it
 */
public class BoardStatus {

    private final Board board;

    public BoardStatus(Board board) {
        this.board = board;
    }

//   Check if board is full. - all cells are filled
//   It does take n*n time. there is no other way?
    public boolean isFull(){

        Iterator boardIterator =  board.iterator();

        while ( boardIterator.hasNext()){
            Cell cell = (Cell) boardIterator.next(); // is this right? Why do I need to cast?
            if (!cell.isFilled())
                return false;
        }

        return true;
    }

//   Predict the Win moves- row wise win
    public boolean winByRowForMe(){

//      Get each row and compare

        return true;
    }

    public boolean winByRowForHim(){
        return true;
    }

    public boolean winByColForMe(){
        return true;
    }

    public boolean winByColForHim(){
        return true;
    }

    public boolean winByDiagonalForMe(){
        return true;
    }

    public boolean winByDiagonalForHim(){
        return true;
    }


}
