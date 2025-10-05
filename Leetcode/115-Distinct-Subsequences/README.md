
This one is pretty straight forward after figuring out the dp[][] physical meaning.

And the function:

dp[i][j] = dp[i-1][j-1] + dp[i-1][j] // if S[i-1] == T[j-1]
= dp[i-1][j] // if S[i-1] != T[j-1]

Answer : dp[n][m]

