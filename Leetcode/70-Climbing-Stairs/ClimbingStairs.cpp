class Solution {
public:
    int climbStairs(int n) {
        if (n<=0) {
            return 0;
        } 
        if (n<3) {
            return n;
        }
        int dp[2];
        dp[0] = 1;
        dp[1] = 2;
        for (int i=2; i<n; i++) {
            dp[i%2] = dp[(i-1)%2] + dp[(i-2)%2];
        }
        return dp[(n-1)%2];
    }
};

