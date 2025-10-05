
Brute force is like,  get each subarray, and get the sum for the sub-range. If it equals to k, update max.   

Space O(1) Time O(n^2).   
========================================
For Time O(n^2), it is not good to use dp. dp takes O(n^2) space and time.   

I would think of using a queue, or two pointer to build a sliding window, like i and j, so any time the length is j-i+1.    

We make a sum to track the sum of the sliding window,
If the sum equals to k, then update max; 
If the sum is bigger then k and  arr[i] >0, then i++;
If the sum is less then k and arr[i] < 0, then i++;
if (j == arr.length-1) i++; 
else j++;

Space O(1), Time O(n).   
============================================

Turns out that this does not work, let us look at prefix sum.  
Let sum[i] = sum of {0...i-1}    So sum[i, j] =sum[j+1] - sum[i], sum[0] = 0;

sum[j+1] - sum[i] == k  => sum[j+1] = k + sum[i];    Use a map <k+sum[i], i> to persist the index, and we can j+1-i is the result.  

we would like the length to be as big as possible, so index should be as left, and we want to traverse to the end.    

Space O(n), Time O(n) . 

