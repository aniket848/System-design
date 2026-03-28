package Strategy;

import Engine.Board;
import Engine.Symbol;

public interface Rules {

    public boolean checkWin(Board b, Symbol s);
    public boolean checkDraw(Board b);
    public boolean checkValidMove(Board b, int x, int y);
}
