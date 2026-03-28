package Strategy;

import Engine.Board;
import Engine.Symbol;

public class StandardRules implements Rules{
    @Override
    public boolean checkWin(Board b, Symbol s) {
        int size = b.getSize();

        // check rows
        for(int i=0;i<size;i++){
            boolean win = true;
            for(int j=0;j<size;j++){
                if(b.getCellValue(i,j)!=s){
                    win = false;
                    break;
                }
            }//j
            if(win)
                return true;
        }

        // check columns
        for(int i=0;i<size;i++){
            boolean win = true;
            for(int j=0;j<size;j++){
                if(b.getCellValue(j,i)!=s){
                    win = false;
                    break;
                }
            }//j
            if(win)
                return true;
        }


        // check diagonals
        boolean win = true;
        for(int i=0;i<size;i++){
            if(b.getCellValue(i,i)!=s){
                win = false;
                break;
            }
        }

        if(win)
            return true;


        // check anti-diagonal
        win = true;
        for(int i=0;i<size;i++){
            if(b.getCellValue(size-i-1,i)!=s){
                win = false;
                break;
            }
        }

        if(win)
            return true;

        return false;
    }

    @Override
    public boolean checkDraw(Board b) {
        boolean draw = true;
        int size = b.getSize();

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(b.getCellValue(i,j).getSymbol()=='_'){
                    draw = false;
                    break;
                }
            }//j
            if(!draw)
                break;
        }//i

        return draw;
    }

    @Override
    public boolean checkValidMove(Board b, int x, int y) {
        int size = b.getSize();

        if(x>=0 && x<size && y>=0 && y<size){
            return !b.checkEmpty(x,y);
        }
        return false;
    }
}
