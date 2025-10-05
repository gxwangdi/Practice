
Basically DP Approach.

dp[0] = A[0]
dp[1] = MAX(dp[0], A[1])

dp[i] = MAX(dp[i-1], A[i]+dp[i-2]) i= 2....n-1.

answer is dp[i-1].

