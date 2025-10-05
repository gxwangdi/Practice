public class ClimbingStairs {
  public int climbStairs(int n) {
        if (n<3) {
            return n;
        }
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2; i<n; i++) {
            dp[i%2] = dp[(i-1)%2] + dp[(i-2)%2];
        }
        return dp[(n-1)%2];
    }
    
    // public int climbStairs(int n) {
    //     if (n<=0)
    //         return 0;
    //
    //     int[] dp = new int[n];
    //     dp[0] = 1;
    //     if (1<n)
    //         dp[1] = 2;
    //
    //     for (int i=2; i<n; i++) {
    //         dp[i] = dp[i-1] + dp[i-2];
    //     }
    //     return dp[n-1];
    // }

    /* // Fibo times out.
    private int fibo(int n) {
        if (n<=0)
            return 0;

        if (n<3)
            return n;

        return fibo(n-1) + fibo(n-2);
    }
    */
}
