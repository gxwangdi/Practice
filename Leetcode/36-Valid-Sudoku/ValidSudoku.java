import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null)
            return false;
        
        Set<Character> set;
        // check rows.
        for (int i=0; i<board.length; i++) {
            set = new HashSet<>();
            for (int j=0; j<board[i].length; j++) {
                if (board[i][j]!='.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    } else {
                        set.add(board[i][j]);
                    }
                }
            }
        }
        
        // check columns
        for (int j=0; j<board.length; j++) {
            set = new HashSet<>();
            for (int i=0; i<board.length; i++) {
                if (board[i][j]!='.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    } else {
                        set.add(board[i][j]);
                    }
                }
            }
        }
        
        // check sub matrix
        for (int i=1; i<board.length; i+=3) {
            for (int j=1; j<board.length; j+=3) {
                set = new HashSet<>();
                for (int k=-1; k<2; k++) {
                    for (int l=-1; l<2; l++) {
                        if (board[i+k][j+l]!='.') {
                            if (set.contains(board[i+k][j+l])) {
                                return false;
                            } else {
                                set.add(board[i+k][j+l]);
                            }
                        }
                    }
                }
            }
        }
        return true;   
    }// end of isValidSudoku       
}



