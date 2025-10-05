public class AndroidUnlockPatterns {
    
    
    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        // It is only 1-9, so we can hard code the skip relationship.
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
        boolean[] visit = new boolean[10];
        int rst = 0;
        for (int i=m; i<=n; i++) {
            rst += dfs(visit, skip, 1, i-1)*4; // 1,3,5,7 are symmetric.
            rst += dfs(visit, skip, 2, i-1)*4; // 2,4,6,8 are symmetric.
            rst += dfs(visit, skip, 5, i-1);
        }
        return rst;
    }
    
    // cur: the current position.
    // remain: the steps remaining.
    private int dfs(boolean[] visit, int[][] skip, int cur, int remain) {
        if (remain < 0) {
            return 0;
        }
        if (remain == 0) {
            return 1;
        }
        visit[cur] = true;
        int rst = 0;
        for (int i=1; i<=9; i++) {
            // If visit is not visited and two number are adjacent or skip number is visited
            if (!visit[i] && (skip[cur][i]==0 || visit[skip[cur][i]])) {
                rst += dfs(visit, skip, i, remain-1);
            }
        }
        visit[cur] = false;
        return rst;
    }// end of dfs    
    
    
    
    
    /*
    public int numberOfPatterns(int m, int n) {
        // if (m < 1 || n > 9) {
        //     return 0;
        // }     
        m = Math.max(m, 1);
        n = Math.min(n, 9);
        
        int[] res = new int[1];
        // res[0] = 0;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                Pair p = new Pair(i, j);
                Set<Pair> set = new HashSet<>();
                set.add(p);
                helper(set, p, m, n, res);
            }
        }
        return res[0];
    }
    
    private void helper(Set<Pair> prog, Pair head, int m, int n, int[] res) {
        if (prog.size()>n) {
            return;
        }
        if (prog.size()>=m) {
            res[0]++;
        }
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                Pair p = new Pair(i, j);
                if (prog.contains(p)) {
                    continue;
                }
                if (isValid(head, p, prog)) {
                    Set<Pair> set = new HashSet<>(prog);
                    set.add(p);
                    helper(set, p, m, n, res);
                }
            }
        }
    }// end of helper   
    
    
    private boolean isValid(Pair s, Pair e, Set<Pair> set) {
        int diffX = Math.abs(s.x-e.x);
        int diffY = Math.abs(s.y-e.y);
        
        if ( diffX<=1 &&  diffY<=1) {
            return true;
        }
        
        if (diffX == 2 && diffY == 2 && set.contains(new Pair(1,1))) {
            return true;
        } 
        
        // if (diffX == 2 && diffY == 1) {
        //     int x = 1;
        //     if (set.contains(new Pair(x, s.y)) && set.contains(new Pair(x, e.y))) {
        //         return true;
        //     }
        // }
        
        // if (diffX == 1 && diffY == 2) {
        //     int y = 1;
        //     if (set.contains(new Pair(s.x, y)) && set.contains(new Pair(e.x, y))) {
        //         return true;
        //     }
        // }
        
        if (diffX == 2 && diffY == 0) {
            if (set.contains(new Pair(1, s.y))) {
                return true;
            }
        }
        
        if (diffY == 2 && diffX == 0) {
            if (set.contains(new Pair(s.x, 1))) {
                return true;
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
    }// end of Pair.   
    */
}






