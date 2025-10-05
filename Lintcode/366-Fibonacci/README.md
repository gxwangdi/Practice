
A DP array with size n could be a good idea, with Space Complexity O(n).  

When it is clear that only the last two partial result is useful for the next step, we can use rolling DP array, like dp[i%2] = dp[(i-1)%2] + dp[(i-2)%2];  

Space Complexity O(1). 

