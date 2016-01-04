package tictactoe;

import tictactoe.Board;
import tictactoe.Cell;

import java.util.List;
import java.util.Scanner;

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

    public void play() throws Exception {
        if (bot == null || human == null)
            throw new Exception("Insufficient players");

        if (board == null)
            throw new Exception("tictactoe.Board is not Initialized");

        while (!isOver()){
            Cell hisCell = move();
            board.makeHisMove(hisCell.getRow(),hisCell.getColumn());

            Cell cell = board.nextFreePosition();
            board.makeMyMove(cell.getRow(),cell.getColumn());
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
     * tictactoe.Game Status :
     * Winner      :
     * Win By      :
     * tictactoe.Board       :
     */
    public String endPlay() throws Exception {
        if (!isOver())
            throw new Exception("tictactoe.Game is not over");

        String winner = "None";
        String winBy  = "tictactoe.Board is Full";

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
            winBy = "tictactoe.Board is Full";
        }
        String boardValue = board.toString();
        return new String( "END" + "\n" + winner + "\n" + winBy + "\n" + boardValue);
    }

    /*
     * isOver- Checks if the tictactoe.Game is over.
     * Possible Scenario: Any tictactoe.Player had Won the game
     *                  : tictactoe.Board is full without any winners?
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

        List<List<Cell>> columns = board.getAllColumns();

        for ( List<Cell> column : columns){
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
        List<List<Cell>> rows = board.getAllRows();
        for ( List<Cell> row : rows){
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
        List<List<Cell>> diagonals = board.getDiagonals();

        for ( List<Cell> diagonal : diagonals){
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
