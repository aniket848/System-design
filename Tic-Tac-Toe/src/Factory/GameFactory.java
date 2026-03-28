package Factory;

import Enum.GameType;
import Strategy.StandardRules;
import Game.TicTacToeGame;

public class GameFactory {

    public static TicTacToeGame createGame(int size, GameType gt){
        if(GameType.STANDARD == gt){
            return new TicTacToeGame(size, new StandardRules());
        }
        else{
            return new TicTacToeGame(size, new StandardRules());
        }
    }
}
