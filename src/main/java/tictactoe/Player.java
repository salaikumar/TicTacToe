package tictactoe;

/**
 * tictactoe.Player Class
 * Since it is a two player tictactoe.Game, At max two instances of this class will be present
 * I'll try to make it work and then correct the logic
 */
public class Player {

    private String playerName;
    private Character cellValue;
    private boolean bot;         // bot will be true for Bot player

    public Player(String playerName, Character cellValue){
        this.playerName = playerName;
        this.cellValue  = cellValue;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Character getCellValue() {
        return cellValue;
    }

    public boolean makeBot(){
        bot = true;
        return  true;
    }

    public boolean isBot(){
        return bot == true;
    }
}
