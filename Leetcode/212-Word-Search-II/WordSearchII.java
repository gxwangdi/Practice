import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                dfs(res, board, i, j, root);
            }
        }
        return res;
    }// end of findWords

    private void dfs(List<String> res, char[][] board, int i, int j, TrieNode p) {
        char c = board[i][j];
        if (c == '#' || p.next[c-'a'] == null) {
            return;
        }
        p = p.next[c-'a'];
        if (p.word!=null) {
            res.add(p.word);
            p.word = null;  // avoid duplicate result.
        }
        board[i][j] = '#'; // eat in
        if (i>0) {
            dfs(res, board, i-1, j, p);
        }
        if (j>0) {
            dfs(res, board, i, j-1, p);
        }
        if (i<board.length-1) {
            dfs(res, board, i+1, j, p);
        }
        if (j<board[0].length-1) {
            dfs(res, board, i, j+1, p);
        }
        board[i][j] = c; // poll out. 
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String s:words) {
            TrieNode p = root;
            char[] arr = s.toCharArray();
            for (char c: arr) {
                int index = c-'a';
                if (p.next[index] == null) {
                    p.next[index] = new TrieNode();
                }
                p = p.next[index];
            }
            p.word = s;
        }
        return root;
    }

    private static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    // Based on word Search
    // public List<String> findWords(char[][] board, String[] words) {
    //     var res = new ArrayList<String>();
    //     if (words == null || words.length < 1 || board == null || board.length < 1) {
    //         return res;
    //     }
    //     for (String s : words) {
    //         var visited = new boolean[board.length][board[0].length];
    //         strLoop:
    //         for(int i=0; i<board.length; i++) {
    //             for(int j=0; j<board[0].length; j++) {
    //                 if (board[i][j] != s.charAt(0)) {
    //                     continue;
    //                 }
    //                 visited[i][j] = true;
    //                 if (helper(board, visited, i, j, s, 1)) {
    //                     res.add(s);
    //                     break strLoop;
    //                 }
    //                 visited[i][j] = false;
    //             }
    //         }
    //     }
    //     return res;
    // }
    //
    // private boolean helper(char[][] board, boolean[][] visited, int i, int j, String s, int cur) {
    //     if (cur == s.length()) {
    //         return true;
    //     }
    //     for(int di=-1; di<=1; di++) {
    //         for(int dj=-1; dj<=1; dj++) {
    //             if (di * dj != 0) {
    //                 continue;
    //             }
    //             var x = i+di;
    //             if (x <0 || x >= board.length) {
    //                 continue;
    //             }
    //             var y = j+dj;
    //             if (y <0 || y >= board[0].length) {
    //                 continue;
    //             }
    //             if (visited[x][y]) {
    //                 continue;
    //             }
    //             if (board[x][y] != s.charAt(cur)) {
    //                 continue;
    //             }
    //             visited[x][y] = true;
    //             if (helper(board, visited, x, y, s, cur+1)) {
    //                 return true;
    //             }
    //             visited[x][y] = false;
    //         }
    //     }
    //     return false;
    // }




    /*
    // Using pair(x,y) in a set does not help avoid duplicates
    // now it does not pass case like {["aa"], ["aaa"]}.
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || words == null || words.length == 0) {
            return res;
        }
        Set<String> set = new HashSet<>();
        for (String word : words) {
            if (isMatch(board, word)) {
                set.add(word);
            }
        }
        res.addAll(set);
        return res;
    }// end of findWords

    private boolean isMatch(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char c = word.charAt(0);
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j]!=c) {
                    continue;
                }
                // int[] pair = new int[2];
                // pair[0] = i;
                // pair[1] = j;
                Set<Pair> s = new HashSet<>();
                s.add(new Pair(i, j));
                if (isMatch(board, s, i, j, word, 1)) {
                    return true;
                }
            }
        }
        return false;
    }// end of isMatch

    private boolean isMatch(char[][] board, Set<Pair> s, int x, int y, String word, int cur) {
        if (cur == word.length()) {
            return true;
        }
        for (int i=x-1; i<=x+1; i++) {
            for (int j=y-1; j<=y+1; j++) {
                if (i<0) continue;
                if (i>=board.length) continue;
                if (j<0) continue;
                if (j>=board[0].length) continue;
                // int[] pair = {i, j};
                Pair p = new Pair(i, j);
                if (s.contains(p)) continue;
                if (word.charAt(cur)!=board[i][j]) continue;
                s.add(p);
                if (isMatch(board, s, i, j, word, cur+1)) {
                    return true;
                }
                s.remove(p);
            }
        }
        return false;
    }

    private static class Pair {
        public int x;
        public int y;
        public Pair(int i, int j) {
            x = i;
            y = j;
        }
    }// end of Pair
    */
}
