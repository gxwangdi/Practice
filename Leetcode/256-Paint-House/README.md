
This looks like dp, 

dp[m][n], where m is the number of houses, and n is the number of colors.  dp[i][j] means the minimum cost of painting house 0~i, and painting the (i+1)th house using color j+1.     

dp[0][j] = cost[0][j].   dp[i][j] = min(dp[i-1][j']) + cost[i][j];  // j` != j.

answer is the min(dp[m-1][j])   

Space O(mn),  Time O(mn)       

