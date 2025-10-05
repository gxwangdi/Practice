
Well, basically dp approach, as I can see a lot of duplicate computing inside.  

dp[i, j] means take matrix[i, j] as the right-bottom corner, the max edge.  

init dp[0, j] = 1 if matrix[0, j] = '1', or else 0.  Same for dp[i, 0].   

dp[i, j] = min(dp[i-1, j-1], dp[i-1, j], dp[i, j-1]) + 1.    

answer is the max*max, max is the max value in dp array, so keep a max to record max dp.    

 