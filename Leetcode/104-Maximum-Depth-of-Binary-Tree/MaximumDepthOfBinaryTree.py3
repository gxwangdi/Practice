# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def max(i1, i2 : int) -> int:
        if i1 >= i2:
            return i1
        return i2
    
    def maxDepth(self, root: TreeNode) -> int:
        if root == None :
            return 0
        
        return max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1
    
