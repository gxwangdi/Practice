
If it is not a complete binary tree,  then count it in recursive manner.   

Space O(logn),  Time O(n).   
==================================
A complete binary tree, level i has 2^(i-1) nodes.  The thing is, for the last level, it is not necessarily full,  so when counting, from top to bottom, but every level just accumulates the biggest full level it can have.   

Space O(logn),  Time O(lognlogn)
   



