public class NQueensII {
    public int totalNQueens(int n) {
        if (n<1) {
            return 0;
        }
        int[] res = new int[1];
        boolean[] ocp90 = new boolean[n];
        boolean[] ocp45 = new boolean[2*n-1];
        boolean[] ocp135 = new boolean[2*n-1];
        dfs(res, 0, n, ocp90, ocp45, ocp135);
        return res[0];
    }// end of totalNQueens     
    
    private void dfs(int[] res, int depth, int n, boolean[] ocp90, boolean[] ocp45, boolean[] ocp135) {
        if (depth == n) {
            res[0]++;
            return;
        }
        
        for (int j=0; j<n; j++) {
            if (!ocp90[j] && !ocp45[depth+j] && !ocp135[j-depth+n-1]) {
                ocp90[j] = true;
                ocp45[depth+j] = true;
                ocp135[j-depth+n-1] = true;
                dfs(res, depth+1, n, ocp90, ocp45, ocp135);
                ocp90[j] = false;
                ocp45[depth+j] = false;
                ocp135[j-depth+n-1] = false;
            }
        }
    }// end of dfs
}









