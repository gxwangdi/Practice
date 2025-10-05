public class PaintFence {
    public int numWays(int n, int k) {
        if (n<=0 || k<=0) {
            return 0;
        }
        if (n ==1) {
            return k;
        }
        if (n ==2) {
            return k*k;
        }
        int[] dp = new int[3];
        dp[0] =1;
        dp[1] =k;
        dp[2] =k*k;
        int cur =3;
        while (cur < n+1) {
            dp[cur%3] = (k-1)*(dp[(cur-1)%3] + dp[(cur-2)%3]);
            cur++;
        }
        return dp[(cur-1)%3];
    }
}


