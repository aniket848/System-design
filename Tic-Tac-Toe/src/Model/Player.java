package Model;

import Engine.Symbol;

public class Player {

    private int id;
    private String name;
    private Symbol symbol;
    private int score;

    public Player(int id, String name, Symbol symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.score = 0; // Initial score
    }

    public int getScore(){
        return score;
    }

    public void incrementScore() {
        score++;
    }

    public String getName(){
        return name;
    }

    public Symbol getSymbol(){
        return symbol;
    }
}
