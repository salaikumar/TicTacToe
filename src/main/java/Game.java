import java.util.ArrayList;

/**
 * Game Class
 * Implements the methods required to play the game
 */
public class Game {
    private Player bot;
    private Player human;
    private Board board;

    public Player getBot() {
        return bot;
    }

    public void setBot(Player bot) {
        this.bot = bot;
    }

    public Player getHuman() {
        return human;
    }

    public void setHuman(Player human) {
        this.human = human;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    //  Methods
    public void play(){

    }

    public void endPlay(){

    }

    /*
     * isOver- Checks if the Game is over.
     * Possible Scenario: Any Player had Won the game
     *                  : Board is full without any winners?
     */
    public boolean isOver(){

        if ( isWinnerPresent())
            return true;

        if ( board.isFull())
            return true;

        return false;
    }

    public boolean isWinnerPresent() {
        return isBotWinner() || isHumanWinner();
    }

    /*
     * Check if Bot had Win the game
     * Possible Winning : occupy One Complete Row
     *                  : occupy One Complete Column
     *                  : occupy  One Complete Diagonal
     */
    public boolean isBotWinner(){
        return winByRow(bot) || winByColumn(bot) || winByDiagonal(bot);
    }

    public boolean isHumanWinner(){
        return winByRow(human) || winByColumn(human) || winByDiagonal(human);
    }

//  What is the point in me sending the properties of the same class as argument?
//  Is that right?
//  Let's think over it
    private boolean winByColumn(Player player) {

        Character value = player.getCellValue();
        Boolean   colMatch = false;

        ArrayList<ArrayList<Cell>> columns = board.getAllColumns();

        for ( ArrayList<Cell> column : columns){

            for (Cell cell : column){

                 if ( value != cell.getValue()){
                     colMatch = false;
                     break;
                 }
                 colMatch = true;
            }

            if ( colMatch )
                return true;
        }

        return  false;
    }

    private boolean winByRow(Player player) {
        Character value = player.getCellValue();
        Boolean   rowMatch = false;

        ArrayList<ArrayList<Cell>> rows = board.getAllRows();

        for ( ArrayList<Cell> row : rows){

            for (Cell cell : row){

                if ( value != cell.getValue()){
                    rowMatch = false;
                    break;
                }
                rowMatch = true;
            }

            if ( rowMatch )
                return true;
        }

        return  false;
    }

    private boolean winByDiagonal(Player player) {
        Character value = player.getCellValue();
        Boolean   diaMatch = false;

        ArrayList<ArrayList<Cell>> diagonals = board.getDiagonals();

        for ( ArrayList<Cell> diagonal : diagonals){

            for (Cell cell : diagonal){

                if ( value != cell.getValue()){
                    diaMatch = false;
                    break;
                }
                diaMatch = true;
            }

            if ( diaMatch )
                return true;
        }

        return  false;
    }


    //  This feature will be implemented later.
//  I should just set all properties to null?
//  Or reset the  Board alone? Clearing all values in Cells?
//  I think the second one is more opt.
//  Pushing to later...
    public boolean reset(){
        return false;
    }
}
