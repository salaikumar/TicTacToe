/**
 * Human Player class.
 * I see bad smells in my code.
 * Let me make this game complete and refactor it properly
 */
public class Human {

    private final Character val = 'O';
    private String name;

    public Human(String name){
        this.name = name;
    }

    public Character getVal() {
        return val;
    }

    public String getName() {
        return name;
    }
}
