
My solution would be:
1. Find the smallest number and get the index, i;
2. Split the array into two parts, first half is [0.....i-1], [i.....nums.length-1] 
3. Compare with edge of each subarray and do binary serach in corresponding subarray.

Space O(1), Time O(logn)

jiuzhang official answer gives an answer that basically runs one round binary serach on the array. 
It checks if the answer is in the ordered half, and exclude the part that does not have the answer.

This is the POINT of binary search.

