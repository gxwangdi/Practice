
dp[i][j]: minimum number of money to guarantee win for subproblem [i, j]

Target: dp[1][n]  

Corner case: dp[i][i] = 0  

we can choose k (i<=k<=j) as our guess, and pay price k. After our guess, the problem is divided into two subproblems. Notice we do not need to pay the money for both subproblems. We only need to pay the worst case (because the system will tell us which side we should go) to guarantee win. 

So dp[i][j] = min (i<=k<=j) { k + max(dp[i][k-1], dp[k+1][j]) }      

Pay Attention, the selection of k is not like binary selection, it is more like random. 

