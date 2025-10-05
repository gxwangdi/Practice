# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        res = self.getDiameter(root)
        return res[0]

    def getDiameter(self, node: TreeNode) -> List[int]:
        res = [0]*2
        if not node:
            return res
        left = self.getDiameter(node.left)
        right = self.getDiameter(node.right)
        res[0] = max(left[1]+right[1], max(left[0], right[0]))
        res[1] = max(left[1], right[1]) + 1
        return res

    
