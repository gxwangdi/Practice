# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def getHeight(self, node):
        if node == None:
            return 0
        left = self.getHeight(node.left)
        right = self.getHeight(node.right)
        if left == -1 or right == -1:
            return -1
        if abs(left-right)>1:
            return -1
        return max(left, right) + 1
    
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root == None:
            return True
        if self.getHeight(root) == -1:
            return False
        return True


