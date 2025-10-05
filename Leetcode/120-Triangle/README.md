
Basically dp.   

For dp[i][0] and dp[n][n] there is only one route, so precompute.   

dp[i][j] = min( dp[i-1][j-1], dp[i-1][j] );       

Get the min of dp[n-1][j].   

Space O(n), Time O(n).    

 