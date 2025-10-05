public class PaintHouse {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int m = costs.length;
        int n = costs[0].length;
        int[][] dp = new int[m][n];    
        
        for (int j=0; j<n; j++) {
            dp[0][j] = costs[0][j];
        }
        
        for (int i=1; i<m; i++) {
            for (int j=0; j<n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k=0; k<n; k++) {
                    if (k == j) {
                        continue;
                    }
                    min = Math.min(min, dp[i-1][k]);
                }
                dp[i][j] = min + costs[i][j];
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int j=0; j<n; j++) {
            min = Math.min(min, dp[m-1][j]);
        }
        return min;
    }// end of minCost
}





