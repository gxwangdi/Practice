
public class PerfectSquares {
	/**
     * @param n a positive integer
     * @return an integer
     */
    // DP
    public int numSquares(int n) {
        if (n < 1) {
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i=1; i<=n; i++) {
            int min = Integer.MAX_VALUE;
            int j=1;
            while (i-j*j>=0) {
                min = Math.min(min, dp[i-j*j]+1);
                j++;
            }
            dp[i] = min;
        }
        return dp[n];
    }
     
    /* // Naive search gets TLE. 
    public int numSquares(int n) {
        if (n<1) {
            return INVALID_COUNT;
        }
        int maxSqrt = (int)Math.sqrt(n);
        return helper(n, maxSqrt, 0);
    }
    
    private int helper(int n, int maxSqrt, int count) {
        if (n < 0) {
            return INVALID_COUNT;
        }
        if (n == 0) {
            return count;
        }
        int min = Integer.MAX_VALUE;
        for (int i=maxSqrt; i>=1; i--) {
            int temp = helper(n-i*i, i, count+1);
            if (temp == INVALID_COUNT) {
                continue;
            }
            min = Math.min(min, temp);
        }
        return min;
    }// end of helper        
    
    private final int INVALID_COUNT = -1;
    */
}
