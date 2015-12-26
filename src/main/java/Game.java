import java.util.ArrayList;
import java.util.Scanner;

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


    /*
     * Play
     * play the game till there is no winner or board is not full
     * When this method is called, Assuming, Players and Board is set
     */
    public void play() throws Exception {

//      Check if neccessary conditions to play the game is present
        if (bot == null || human == null)
            throw new Exception("Insufficient players");

        if (board == null)
            throw new Exception("Board is not Initialized");

        while (!isOver()){

            Cell hisCell = move(); // POST to move method ur Parameters?
            board.makeHisMove(hisCell.getRow(),hisCell.getColumn());

            Cell cell = board.nextFreePosition();
            board.makeHisMove(cell.getRow(),cell.getColumn());

            board.toString();
        }

        endPlay();
    }

    public Cell move() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Index Start - (0,0)");
        System.out.println("Enter row of your move ");
        Integer row=  scanner.nextInt();

        System.out.println("Enter col of your move ");
        Integer col = scanner.nextInt();

        return new Cell(row,col,'O');
    }

    /*
     * Method does the things at the end of play
     * Game Status :
     * Winner      :
     * Win By      :
     * Board       :
     */
    public String endPlay() throws Exception {

        if (!isOver())
            throw new Exception("Game is not over");

        String winner = "None";
        String winBy  = "Board is Full";
        if (isWinnerPresent()) {
            winner = winner().getPlayerName();
            if (winByColumn(bot))
                winBy = "COLUMN";
            else if (winByRow(bot))
                winBy = "ROW";
            else
                winBy = "DIAGONAL";
        }
        else  {
            winner = "None";
            winBy = "Board is Full";
        }


        String boardValue = board.toString();
        return new String( "END" + "\n" + winner + "\n" + winBy + "\n" + boardValue);
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

    public Player winner(){
        if ( isBotWinner())
            return bot;
        else if ( isHumanWinner())
            return human;
        return null;
    }

}
