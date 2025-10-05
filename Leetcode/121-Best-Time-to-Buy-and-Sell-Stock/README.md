
Starting from left to right, keep the min element we have ever met, and get the biggest profit.  

Space O(1)   Time O(n)

It is kind of similar to max subarray sum

low array to keep the min from left to right;
high array to keep the max from right to left;
pick the max delta for high[i]-low[i] i = [0, n-1]
