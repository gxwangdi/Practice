Define a struct Result, has found and val.   

If found is true, then val is the value of kth smallest node;
If found is false, then val is the total amount of nodes in the subtree.  

root node check left subtree, 
if found, pass back, if not,  if k==1 pass itself, or  query right subtree updating k as k-left.val-1;
If found in right subtree, pass back, if not, pass (false, left.val+1+right.val).   

Space O (logn)   Time O(k), as we query one by one until we find the kth node.       

===========================================================
Iterative approach could be, inorder traverse every single node in iterative manner, and count how many nodes we have accessed. return the kth node.          

===========================================================
For follow up, if we need to call the API frequently, then we will need to persist information we get from previous operation, like the amount of nodes in the left subtree.  

And all insert/delete operation should update the amount of nodes of left subTree accordingly, which introduces O(logn) complexity.  

 

    