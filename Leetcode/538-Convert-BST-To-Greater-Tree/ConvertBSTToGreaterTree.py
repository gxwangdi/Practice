# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def convertBST(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if not root:
            return root
        self.convert(root, 0)
        return root

    def convert(self, node, sum):
        if not node:
            return sum
        node.val += self.convert(node.right, sum)
        return self.convert(node.left, node.val)
    
