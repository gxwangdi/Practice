public class WordSearch {

  // complement 06/2022
  public boolean exist(char[][] board, String word) {
      if (board == null || board.length < 1) {
          return false;
      }
      if (word.length() <1) {
          return true;
      }
      var visited = new boolean[board.length][board[0].length];
      for(int i=0; i<board.length; i++) {
          for(int j=0; j<board[0].length; j++) {
              if (board[i][j] != word.charAt(0)) {
                  continue;
              }
              visited[i][j] = true;
              System.out.println("i:" + i + " j:" + j);
              if (helper(board, visited, i, j, word, 1)) {
                  return true;
              }

              visited[i][j] = false;
          }
      }
      return false;
  }

  private boolean helper(char[][] board, boolean[][] visited, int i, int j, String word, int cur) {
      if (cur == word.length()) {
          return true;
      }
      var res = false;
      for (int di = -1; di<=1; di++) {
          for (int dj = -1; dj <= 1; dj++) {
              if (di * dj != 0) {
                  continue;
              }
              var x = i+di;
              if (x < 0 || x >= board.length) {
                  continue;
              }
              var y = j+dj;
              if (y < 0 || y >= board[0].length) {
                  continue;
              }
              if (visited[x][y]) {
                  continue;
              }
              if (board[x][y] != word.charAt(cur)) {
                  continue;
              }
              visited[x][y] = true;
              res |= helper(board, visited, x, y, word, cur+1);
              visited[x][y] = false;
              if (res) {
                  return true;
              }
          }
      }
      return res;
  }

    // public boolean exist(char[][] board, String word) {
    //     if (board == null || board.length==0 || word == null || word.length() == 0) {
    //         return false;
    //     }
    //
    //     // board is not a square matrix.
    //     int m = board.length;
    //     int n = board[0].length;
    //     boolean[][] isVisited = new boolean[m][n];
    //     for (int i = 0; i<m; i++) {
    //         for (int j = 0; j<n; j++) {
    //             if (isMatch(board, i, j, isVisited, word, 0)) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
    //
    // private boolean isMatch(char[][] board, int x, int y, boolean[][] isV, String word, int prog) {
    //     if (word.charAt(prog) != board[x][y]) {
    //         return false;
    //     }
    //     // note the order to avoid OutOfIndexException.
    //     prog++;
    //     if (prog >= word.length()) {
    //         return true;
    //     }
    //     isV[x][y] = true;
    //     if (x > 0 && !isV[x-1][y] && isMatch(board, x-1, y, isV, word, prog)) {
    //         return true;
    //     }
    //     if (x+1 < board.length && !isV[x+1][y] && isMatch(board, x+1, y, isV, word, prog)) {
    //         return true;
    //     }
    //     if (y > 0 && !isV[x][y-1] && isMatch(board, x, y-1, isV, word, prog)) {
    //         return true;
    //     }
    //     if (y+1 < board[0].length && !isV[x][y+1] && isMatch(board, x, y+1, isV, word, prog)) {
    //         return true;
    //     }
    //     // revert isV[x][y], means pop from stack to upper level of recursion.
    //     isV[x][y] = false;
    //     return false;
    // }// end of isMatch
}
