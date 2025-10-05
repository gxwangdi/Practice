
Easy to find the root, which is the first one in the range, and check if there is an element somewhere in the middle that is bigger than root, that is the boundary of left subtree and right subtree.   

Recursively check this from root to leaf.  

Well, this gets TLE.   Time O(nlogn).    
==============================================

As per the words:

Kinda simulate the traversal, keeping a stack of nodes (just their values) of which we're still in the left subtree. If the next number is smaller than the last stack value, then we're still in the left subtree of all stack nodes, so just push the new one onto the stack. But before that, pop all smaller ancestor values, as we must now be in their right subtrees (or even further, in the right subtree of an ancestor). Also, use the popped values as a lower bound, since being in their right subtree means we must never come across a smaller number anymore.



