/**
 * Class : Cell
 * Individual cells in the Board
 */
public class Cell {

    private final Integer row;
    private final Integer col;
    private Character value;

    /*
     * Create a new cell with row and column
     */
    public Cell(Integer row, Integer col) {
        this.row = row;
        this.col = col;
    }

    /*
     * Create a new cell with  row, column and its value
     */
    public Cell(Integer row, Integer col, Character value){
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public boolean setValue(Character value){
        if (isFilled())
            return false; // might be replaced with exception as well

        this.value = value;
        return true;
    }

    public boolean isFilled(){
        return this.value == null;
    }

//   Is there a better way to do it?
//   It might return null,which I don't want
    public Character getValue(){
        return this.value;
    }

}
