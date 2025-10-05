
Obviously dynamic programming.   

dp[0][0] = a[0][0];
dp[i][0] = dp[i-1][0] + a[i][0];
dp[0][i] = dp[0][i-1] + a[0][i];
dp[i][j] = min( dp[i-1][j] , dp[i][j-1] ) + a[i][j];   

return dp[m-1][n-1].   

Space O(n2),  Time O(n2).   

