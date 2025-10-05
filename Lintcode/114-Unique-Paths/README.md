
Init: dp[i, j] = 1 for all i == 0 || j == 0.
Function: dp[i, j] = dp[i-1, j] + dp[i, j-1]; 
Result dp[m-1, n-1].

DP is fine, but it is actually a permutation problem.

There must be m-1 downs and n-1 rights. How many permutation will be there?

P(n, r) = n! / (n-r)!
C(n, r) = n! / (r! * (n-r)! )

Pay attention to m--; n--; when coding this solution, as it is couting path, and there is m-1 paths between m nodes, n-1 paths between n nodes!

While coding DP it is counting point.

