
If there are random obstacles in the middle, then we can only use dp[i][j].  

if nums[i][j] == 1, dp[i][j] = 0;
else dp[i][j] = dp[i-1][j] + dp[i][j-1].    

Space O(n2), Time O(n2).    

