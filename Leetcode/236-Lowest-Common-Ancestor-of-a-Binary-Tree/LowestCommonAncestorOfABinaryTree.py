# Python 3 solution

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        return self.lca(root, p, q);

    def lca(self, root, p, q):
        if root is None or p is None or q is None:
            return None
        if root == p or root == q:
            return root

        left = self.lca(root.left, p, q)
        right = self.lca(root.right, p, q)

        if left is not None and right is not None:
            return root

        return left if left is not None else right

