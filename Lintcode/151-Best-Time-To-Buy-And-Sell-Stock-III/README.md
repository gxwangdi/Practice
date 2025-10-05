
The max profit can be achieved by separate the array into two parts, 0...i, i+1....len-1.

Define dp[i] = maxProfit(0,..., i) + maxProfit(i+1, ..., len-1).

Then the answer is max (dp[0], dp[1]....dp[len-1]).

Space O(n), Time O(n2).

