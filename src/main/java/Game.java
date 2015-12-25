/**
 * Game Class
 * This class helps u play the actual game.
 */
public class Game {

//  Players.
    private Bot bot;
    private Human human;

//  Board
    private Board board;


//  Default Constructor
//  Not sure if I need to type this.
    public Game(){

    }

    public Bot getBot() {
        return bot;
    }

    public void setBot(Bot bot) {
        this.bot = bot;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
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

    public boolean reset(){
        return false;
    }

    public boolean isOver(){
        return false;
    }

    public boolean isBotWinner(){
        return false;
    }

    public boolean isHumanWinner(){
        return false;
    }

}
