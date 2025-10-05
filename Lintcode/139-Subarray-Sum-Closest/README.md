
Based on subArray sum, we will need to maintain an ap array, min var, andm maybe a dp2 array based on dp?

Space O(n), Time O(n)
Well, if brute force manner only cost O(n^2), do we need to use dp?

Here is the trick:
get sum[i] = sum{nums[0...i-1]}. So we change the range into two pointer, which is hopefully to be resoved in O(n).

But the sorting requires O(nlogn).

