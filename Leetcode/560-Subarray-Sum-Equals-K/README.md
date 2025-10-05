
Prefix Sum/Cumulative sum is pretty straight forward to figure out.

For traditional prefix sum, to caculate the sum take O(n), and identify a range takes O(n^2) for time and O(n).

While we calculate it, we check if it equals to k, it takes O(n^2) time but O(1) space.

For prefix sum, essentially we are looking for

         X             k
|-----------------|----------|
             Y        
X + k == Y =>  X = Y-k    Y-k is what we know during each iteration when calculating the prefix sum.
So we can store all xs and corresponding frequencies along the way.
This is pretty similar to 2-sum map approach.   
