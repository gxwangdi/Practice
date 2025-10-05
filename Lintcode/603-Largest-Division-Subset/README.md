
if a<b and b%a==0, b<c and c%b==0, then c%a==0.

So need to sort the array first, `cause if it is not sorted, it would be hard to deal with.

Let dp[i] denotes the max length of the subset, then trnasform function is,
dp[x] = max(dp[x], dp[y]+1), of which 0<= y < x and nums[x] % nums[y] == 0

