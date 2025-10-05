
Looks like an array 1...n as an inorder traversal for a BST, how many possible combination it could be.

如果数组为空，毫无疑问，只有一种BST，即空树，
Count[0] =1 
如果数组仅有一个元素{1}，只有一种BST，单个节点
Count[1] = 1
如果数组有两个元素{1,2}， 那么有如下两种可能
Count[2] = Count[0] * Count[1] (1为根的情况)
+ Count[1] * Count[0] (2为根的情况。

Count[3] = Count[0]Count[2] (1为根的情况)
+ Count[1]Count[1] (2为根的情况)
+ Count[2]*Count[0] (3为根的情况)

由此观察，可以得出Count的递推公式为
Count[i] = ∑ Count[0...k] * [ k+1....i] 0<=k<i-1
问题至此划归为一维动态规划。

当数组为 1，2，3，4，.. i，.. n时，基于以下原则的BST建树具有唯一性：
以i为根节点的树，其左子树由[0, i-1]构成， 其右子树由[i+1, n]构成。

==========================================================
Searched online and found that this is an example of Catalan Number (https://en.wikipedia.org/wiki/Catalan_number#Applications_in_combinatorics),

