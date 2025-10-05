
dp[i] = dp[i-1] + dp[i-2] + dp[i-3]; 
dp[0] = 0
dp[1] = 1
dp[2] = 2
dp[3] = 4    

With rolling dp array, it could save some space.    
