# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def min(self, i1, i2:int) -> int:
        if i1 <= i2:
            return i1
        return i2
    
    def getMin(self, node: TreeNode) -> int:
        if node == None:
            return sys.maxsize
        if node.left == None and node.right == None:
            return 1
        return self.min(self.getMin(node.left), self.getMin(node.right))+1
    
    def minDepth(self, root: TreeNode) -> int:
        if root == None:
            return 0
        return self.getMin(root)
    
        
