
dynamic programming.

dp[i] denotes the when bag capacity is i, the max space it can fill. Two level loop iterations:
1. loop traverse A;
2. reverse traverse dp. 
Equation:
if j >= A[i], dp[j] = Math.max(dp[j], dp[j-A[i]] + A[i])

