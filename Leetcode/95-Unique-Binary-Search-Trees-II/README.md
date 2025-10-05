
For inorder traversal sequence 1...n,     if taking i as root, then 1...i-1 is left subtree, and i+1....n is right subtree.    

From Unique BST we know that the result is a catalan number, NP complexity. So use recursion under a loop to resolve this issue.   

PAY ATTENTION to edge case, like when n<1 we will need to return empty result set, not null,  and when left>right we still need to add null to the result set.  
