/**
 * Class : Cell
 * Individual cells in the Board
 * Possible Cell Values : X, O
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

        if (!isValidValue(value))
            return false;

        this.value = value;
        return true;
    }

    private boolean isValidValue(Character value) {
        if ( value != 'X' && value != 'O')
            return false;
        return true;
    }

    public boolean isFilled(){
        return this.value != null;
    }

//   Is there a better way to do it?
//   It might return null,which I don't want
    public Character getValue(){
        return this.value;
    }

//   Return the row
    public Integer getRow(){
        return  this.row;
    }

//  Return Col
    public Integer getColumn(){
        return  this.col;
    }

//   Not yet tested.
    @Override
    public String toString(){
        return new String( String.valueOf(row) + ',' + String.valueOf(col) + '-' + this.value);
    }

}
