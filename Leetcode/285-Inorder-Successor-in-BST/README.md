
A good way to get this is like to do an iterative in-order traversal, and check target node;  

Space O(logn)    Time O(n).   

It is BST, so we can search the target node, and maintain a stack, the stack should be like it just does a in-order search, and try to get the immediate successor.   

Space O(logn), Time O(logn).   
====================================

Immediate in-order successor is the most left child in the right subtree, or the immediate parent if the target node is the left child.  

Space O(1),   Time (logn).   

 






