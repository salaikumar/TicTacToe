package tictactoe;

/**
 * Class : tictactoe.Cell
 * Individual cells in the tictactoe.Board
 * Possible tictactoe.Cell Values : X, O
 */
public class Cell {

    private final Integer row;
    private final Integer col;
    private Character value;

    public Cell(Integer row, Integer col) {
        this.row = row;
        this.col = col;
    }

    public Cell(Integer row, Integer col, Character value){
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public boolean setValue(Character value){
        if (isFilled())
            return false;

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

    public Character getValue(){
        return this.value;
    }

    public Integer getRow(){
        return  this.row;
    }

    public Integer getColumn(){
        return  this.col;
    }

    @Override
    public String toString(){
        return new String( String.valueOf(row) + ',' + String.valueOf(col) + '-' + this.value);
    }

    @Override
    public boolean equals(Object cell){
        Cell givenCell;

        if ( this == cell)
          return  true;

        if ( !( cell instanceof Cell))
            return false;

        givenCell = (Cell) cell;
        if (    this.getRow() == givenCell.getRow() &&
                this.getColumn() == givenCell.getColumn() &&
                this.getValue() == givenCell.getValue()
            )
                return true;

        return  false;
    }
}
