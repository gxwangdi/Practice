# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def convertBST(self, root: TreeNode) -> TreeNode:
        if not root:
            return root
        self.convert(root, 0)
        return root

    def convert(self, node: TreeNode, sum : int) -> int:
        if not node:
            return sum
        node.val += self.convert(node.right, sum)
        return self.convert(node.left, node.val)

    
