public class ClimbingStairsII {
    /**
     * @param n an integer
     * @return an integer
     */
    public int climbStairs2(int n) {
        if (n <= 0) {
            return 1;
        }
        switch (n) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
            default: // n > 3
                return dp(n);
        }
    }
    private int dp(final int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < dp.length; i++) {
            dp[i % 4] = dp[(i - 1) % 4] + dp[(i - 2) % 4] + dp[(i - 3) % 4];
        }
        return dp[n%4];
    }
}
