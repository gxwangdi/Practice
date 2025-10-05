public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0){
            return 0;
        }
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        for (int j=0; j<k; j++) {
            dp[0][j] = costs[0][j];
        }
        
        for (int i=1; i<n; i++) {
            for (int j=0; j<k; j++) {
                int min = Integer.MAX_VALUE;
                for (int x=0; x<k; x++) {
                    if (x == j) {
                        continue;
                    }
                    min = Math.min(min, dp[i-1][x]);
                }
                dp[i][j] = min + costs[i][j];
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i : dp[n-1]) {
            min = Math.min(min, i);
        }
        return min;
    }
}




