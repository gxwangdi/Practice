import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    private final char x = 'X';
    private final char o = 'O';
    private final char y = 'Y';
    
    private static class Coordinate {
        public int row;
        public int col;
        public Coordinate(int x, int y) {
            this.row = x;
            this.col = y;
        }
    }
    
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        Queue<Coordinate> q = new LinkedList<>();
        int row = 0;
        for (int j=0; j<board[row].length; j++) {
            if (board[row][j] == o) {
                board[row][j] = y;
                q.offer(new Coordinate(row, j));
            }
        }
        row = board.length-1;
        for (int j=0; j<board[row].length; j++) {
            if (board[row][j] == o) {
                board[row][j] = y;
                q.offer(new Coordinate(row, j));
            }
        }
        int col = 0;
        for (int i=0; i<board.length; i++) {
            if (board[i][col] == o) {
                board[i][col] = y;
                q.offer(new Coordinate(i, col));
            }
        }
        col = board[0].length-1;
        for (int i=0; i<board.length; i++) {
            if (board[i][col] == o) {
                board[i][col] = y;
                q.offer(new Coordinate(i, col));
            }
        }
        while (!q.isEmpty()) {
            Coordinate co = q.poll();
            int i = co.row;
            int j = co.col;
            if (i>0 && board[i-1][j] == o) {
                board[i-1][j] = y;
                q.offer(new Coordinate(i-1, j));
            }
            if (i<board.length-1 && board[i+1][j] == o) {
                board[i+1][j] = y;
                q.offer(new Coordinate(i+1, j));
            }
            if (j>0 && board[i][j-1] == o) {
                board[i][j-1] = y;
                q.offer(new Coordinate(i, j-1));
            }
            if (j<board[0].length-1 && board[i][j+1] == o) {
                board[i][j+1] = y;
                q.offer(new Coordinate(i, j+1));
            }
        }
        
        for (int i=1; i<board.length-1; i++) {
            for (int j=1; j<board[0].length-1; j++) {
                if (board[i][j] == o) {
                    board[i][j] = x;
                }
            }
        }
        
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == y) {
                    board[i][j] = o;
                }
            }
        }
        
    }
}



