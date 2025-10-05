
Overall how many possibilities, it is dynamic programming.  

dp[i] means in range 0...i how many possibilities. 
dp[0] == 1
answer is dp[n-1] 
if (arr[i-1] < 3 && arr[i] < 7)  dp[i] = dp[i-1]+1;      

PAY ATTENTION to how int[] nums = new int[s.length()+1]; works here, and how nums[0] is initiated.   



