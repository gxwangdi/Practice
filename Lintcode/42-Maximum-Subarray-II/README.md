
We have left[i] means the max sum in array [0, ... i]; 
right[i] means the max sum in array [i+1, ... n-1].

result is the max in i=[0, ... n-1] left[i] + right[i];

Space O(n), Time O(n).

Pay attetion to how we generate left and right dp arrays.

It is max subarray prefix sum:
http://www.jiuzhang.com/solutions/maximum-subarray/

