
This looks like dp approach.   Not sure if it is optimal.   

dp[i] means the fewest amount of coins it can be for money amount i.   

init: 
dp[0] = 0;
dp[1] = 1;
dp[2] = 1;   
dp[3] = 2;
dp[4] = 2;
dp[5] = 1;
=======
Well, coins array is not hard coded as [1,2,5],  it is like random. whatever amount, and possible that no value 1. like 5, 10, 20.   

transition:
dp[i] = min{dp[x] + dp[i-x]}, x = 0...i/2.

answer:
dp[amount]    

Time O(n^2),   Space O(n).   


