
Based on solution in Jump Game,  we setup dp as int array.   

init as Integer.MAX_VALUE;
if (dp[i] != Integer.MAX_VALUE) 
if i+nums[i] >= len-1, return dp[i]+1; 
dp[i+1....i+nums[i]] = Math.min(dp[i] +1, dp[i+1....i+nums[i]]);   

