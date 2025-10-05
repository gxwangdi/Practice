
Asking for the index in the original array, so I cannot sort.

basically two pointer to build a sliding window. Or dp, dp still consumes O(n2).

Basically using dp[i] indicates the sum from 0 to i, so the sum from i to j sum[i...j] = dp[j] - dp[i-1]. We would like to match the value and get the answer.

