
dp[0....len+1].

dp[0]=1;

dp[i] = 
dp[i-1]; at first, 
dp[i-1]+1; if src[i-1]*10 + src[i] == [10...26].

answer is dp[len].

