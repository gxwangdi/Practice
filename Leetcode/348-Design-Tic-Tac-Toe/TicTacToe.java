public class TicTacToe {

    /*
    private final char empty = '.';
    private final char move1 = 'X';
    private final char move2 = 'O';

    private char[][] board;
    private int len;
    */
    
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        /*
        len = Math.max(n, 1);
        board = new char[len][len];
        for(char[] row:board) {
            Arrays.fill(row, empty);
        }
        */
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int toAdd = player==1?1:-1;
        
        rows[row] += toAdd;
        cols[col] += toAdd;
        
        if (row == col) {
            diagonal += toAdd;
        }
        
        if (col == (cols.length - row - 1)) {
            antiDiagonal += toAdd;
        }
        
        int size = rows.length;
        if (Math.abs(rows[row]) == size ||
            Math.abs(cols[col]) == size ||
            Math.abs(diagonal) == size  ||
            Math.abs(antiDiagonal) == size)
        {
            return player;
        }
        
        return 0;
        /*
        if (player == 1) {
            board[row][col] = 'X';
        } else {
            board[row][col] = 'O';
        }
        if (win(row, col)) {
            return player;
        }
        return 0;
        */
    }// end of move        
    
    /*
    private boolean win(int i, int j) {
        char x = board[i][j];  
        boolean res = true;
        for (int n=0; n<len; n++) {
            if (board[n][j] != x) {
                res = false;
                break;
            }
        }//   
        if (res) return res;
        res = true;
        for (int n=0; n<len; n++) {
            if (board[i][n] != x) {
                res = false;
                break;
            }
        }
        if (res) return res;
    }
    */
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
 
 
 
 
 
 
 
 