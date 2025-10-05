public class GuessNumberHigherOrLowerII {
    
    public int getMoneyAmount(int n) {
        if (n <= 1) {
            return 0;
        }
        
        int[][] dp = new int[n+1][n+1];
        for (int jminusi = 1; jminusi < n; jminusi++) {
            for (int i = 0; i + jminusi <= n; i++) {
                int j = i + jminusi;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                                        k + Math.max(k - 1 >= i ? dp[i][k - 1] : 0,
                                                     j >= k + 1 ? dp[k + 1][j] : 0));
                }
            }
        }
        return dp[1][n];
    }
    
    /*
    // My approach, it does not work this way! 
    public int getMoneyAmount(int n) {
        
        int sum = 0;
        int start = 1;
        int end = n;
        if (start == end) {
            return 0;
        }
        while (start+1 < end) {
            int mid = start + (end-start)/2;
            sum += mid;
            start = mid+1;
        }
        sum += start;
        return sum;
    }
    */
}



