
The reverse version of max depth of binary tree.   

Space O(n)   Time O(logn) 
====================================
Keep in mind that it is root to leaf, which means left and right are both null.   Recursion would easily count branch node, of which left is null, but right is a subtree.   

