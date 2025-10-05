
Take the first element in preorder as root, and find the index in inorder, split into left and right.   

Note that this is not a binary search tree, so inorder is not an ascending order, cannot use binary search.  So it should never have duplicate value, or we will return the wrong index of the root.   

Space O(n)   Time O(nlogn)    

 