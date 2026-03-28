package Game;

import Engine.Board;
import Model.Player;
import Strategy.IObserver;
import Strategy.Rules;
import Strategy.consoleNotifier;

import java.util.*;

public class TicTacToeGame {

    private Board board;
    private Rules rules;
    private Deque<Player> playerList;
    private Boolean gameOver;
    private List<IObserver> observerList;

    public TicTacToeGame(int size, Rules rules){
        this.board = new Board(size);
        this.rules = rules;
        this.gameOver = false;
        this.observerList = new ArrayList<>();
        this.playerList = new ArrayDeque<>();

        this.observerList.add(new consoleNotifier());
    }

    public void addPlayer(Player player){
        playerList.addLast(player);
    }

    public void notify(String message){
        for(IObserver obs: observerList){
            obs.update(message);
        }
    }

    public void play(){
        System.out.println("Game Started!");

        Scanner scanner = new Scanner(System.in);

        while(!gameOver){

            Player currentPlayer = playerList.getFirst();
            System.out.println(currentPlayer.getName() + "'s turn. Enter row and column (0-based index): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if(board.checkEmpty(row,col)){

                board.setSymbol(row,col,currentPlayer.getSymbol());

                notify(currentPlayer.getName() + " placed " + currentPlayer.getSymbol().getSymbol() + " at (" + row + "," + col + ")");
                board.display();

                // check if player wins
                if(rules.checkWin(board, currentPlayer.getSymbol())){
                    notify(currentPlayer.getName() + " wins!");
                    currentPlayer.incrementScore();
                    gameOver = true;
                }
                // else check for draw
                else if(rules.checkDraw(board)){
                    notify("Game is a draw!");
                    gameOver = true;
                }
                else{
                    playerList.removeFirst();
                    playerList.addLast(currentPlayer);
                }

            }
            else{
                System.out.println("Cell is not empty. Try again.");
            }

        }//while

        System.out.println("Game Over!. Final Scores:");
        for(Player player:playerList){
            System.out.println(player.getName() + ": " + player.getScore());
        }

        System.out.println("Do you want to play again? (yes/no)");
        String playAgain = scanner.next();

        if(playAgain.equalsIgnoreCase("Yes")){
            // reset game state
            this.board = new Board(board.getSize());
            this.gameOver = false;
            play();
        }

    }

    public void boardDisplay(){
        board.display();
    }
}
