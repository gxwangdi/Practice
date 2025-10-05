
The best strategy to play the game is to minimize the maximum loss you could possibly face.

Definition of dp[i][j]: minimum number of money to guarantee win for subproblem[i, j].

Target: dp[1](n)   

Corner case: dp[i](i) = 0 `cause the only element must be correct. 

Equation: we can choose k (i <= k <= j) as our guess, and pay price k. After our guess, the problem is divided into two subproblems. Notice we do not need to pay
the money for both subproblems. We only need to pay the worst case to guarantee 
win. So dp[i][j] = min{k+ max(dp[i](k-1), dp[k+1][j])} (i <= k <= j)     

