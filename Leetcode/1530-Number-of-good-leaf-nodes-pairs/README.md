
Note:
To use index indicating the distance is innovative.

https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/discuss/756198/Java-DFS-Solution-with-a-Twist-100-Faster-Explained

Assume maximum distance = 4. So we maintain an array of size 4.

For root node 1,
left = [ 0,0,1,0,0]
right = [0,1,0,0,0]
Here, left[2] = 1, which denotes that there is one leaf node with distance 2 in left subtree of root node 1.
right[1] = 1, which denotes that there is one leaf node with distance 1 in right subtree of root node 1.
In this way, we have to recursively, calculate the left and right subtree of every root node.

Once we have both left and right arrays for a particular root, we have to just calculate total number of good node pairs formed using result += left[l]*right[r];

Before we bactrack to parent, we have to return the distance for parents by adding up left and right subtrees of current node. Note that we are doing - res[i+1] = left[i]+right[i];
The intution is that, if a leaf node is at distance i from current node, it would be at distance i+1 from its parent. Hence, will building the res array, we are adding sum in i+1 th position and return to parent.
