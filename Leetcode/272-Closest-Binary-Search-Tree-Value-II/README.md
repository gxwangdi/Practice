
In-order traverse the binary tree, and binary search the last one that arr[i] <= target.  

Starting from there, two pointers, left and right to expand the result set size to k.  

Space O(n+k) == O(n)   Time O(n + logn + k) == Time O(n)  
==============================================================
Note that the follow up is a good question to ask when clarifying the pre-conditions.         

Hint:
Consider implement these two helper functions:
    getPredecessor(N), which returns the next smaller node to N.
    getSuccessor(N), which returns the next larger node to N.
Try to assume that each node has a parent pointer, it makes the problem much easier.
Without parent pointer we just need to keep track of the path from the root to the current node using a stack.
You would need two stacks to track the path in finding predecessor and successor node separately.

In the process of searching, get depth for right route and depth for left route,  when the depth satisfy 2^right-1 < k < 2^(left)-1, start to collect the k nodes right there.  





   

