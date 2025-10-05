# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def getHeight(self, node: TreeNode) -> int:
        if node == None:
            return 0
        left = self.getHeight(node.left)
        right = self.getHeight(node.right)
        if left == -1 or right == -1:
            return -1
        if abs(left-right)>1:
            return -1
        return max(left, right) + 1
    
    def isBalanced(self, root: TreeNode) -> bool:
        if root == None:
            return True
        if self.getHeight(root) == -1:
            return False
        return True
    
    
