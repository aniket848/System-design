package Engine;

public class Board {

    private int size;
    private Symbol[][] board;
    private Symbol emptySymbol;

    public Board(int size){
        this.size = size;
        board = new Symbol[size][size];
        emptySymbol = new Symbol('_');

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                board[i][j] = emptySymbol;
            }
        }
    }

    public Boolean checkEmpty(int row, int col){
        if(row>=0 && row<size && col>=0 && col<size){
            return board[row][col] == emptySymbol;
        }
        return false;
    }

    public void setSymbol(int row, int col, Symbol symbol){
        if(row>=0 && row<size && col>=0 && col<size){
            board[row][col] = symbol;
        }
    }

    public Symbol getCellValue(int row, int col){
        if(row>=0 && row<size && col>=0 && col<size){
            return board[row][col];
        }
        return null;
    }

    public Symbol[][] getBoard(){
        return board;
    }

    public int getSize(){
        return size;
    }

    public void display(){
        System.out.print("  ");
        for(int i=0;i<size;i++)
            System.out.print(i + " ");

        System.out.println();

        for(int i=0;i<size;i++){
            System.out.print(i + " ");
            for(int j=0;j<size;j++){
                System.out.print(board[i][j].getSymbol() + " ");
            }
            System.out.println();
        }//i

        System.out.println();
    }

}
