import Engine.Symbol;
import Factory.GameFactory;
import Game.TicTacToeGame;
import Enum.*;
import Model.Player;

public class Main {
    public static void main(String[] args) {

        Player player1 = new Player(1,"Aniket",new Symbol('O'));
        Player player2 = new Player(1,"Harsh",new Symbol('X'));

        TicTacToeGame game = GameFactory.createGame(3, GameType.STANDARD);

        game.addPlayer(player1);
        game.addPlayer(player2);

        game.boardDisplay();

        game.play();


    }
}