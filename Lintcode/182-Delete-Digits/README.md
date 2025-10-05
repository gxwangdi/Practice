
DP solution: 
dp(len)(k+1), where len is the length of the string, k is given. dp{i,j} means the optimal intermediate result when we scan the ith char starting from left, and remove j chars. Then the result should be dp[len-1](k).
when j == 0, dp[i](j) = [0...i+1] 
when i < j, dp[i](j) = 0 means remove more char than we have at this time. 
dp[i](j) = min(dp[i-1](j-1), dp[i-1](j)*10+ithchar), of which
dp[i-1](j) means we do not take ith char, while dp[i-1](j)*10+ith char means we take ith char.

Stack:

