
First of all, I will have a Map<level, List<Integer>> collect all nodes in corresponding list.  For each node, the level equals to the highest level of left and right child.   

and I will add values in map from level 1 to level logn, to result set, one by one.  

Space O(n), Time O(n).   

