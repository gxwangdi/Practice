# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root == None :
            return True
        return self.isSymmetricForTwo(root.left, root.right)
    
    def isSymmetricForTwo(self, left, right: TreeNode) -> bool:
        if left == None and right == None:
            return True
        
        if left == None or right == None:
            return False
        
        if left.val != right.val:
            return False
        return self.isSymmetricForTwo(left.left, right.right) and self.isSymmetricForTwo(right.left, left.right)
        
