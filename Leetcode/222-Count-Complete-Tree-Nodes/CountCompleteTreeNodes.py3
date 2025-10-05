# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def countNodes(self, root: TreeNode) -> int:
        h = self.height(root)
        if h < 0:
            return 0
        else:
            if self.height(root.right) == h-1:
                return (1<<h) + self.countNodes(root.right)
            else:
                return (1<<h-1) + self.countNodes(root.left)

    def height(self, node: TreeNode) -> int:
        if node == None:
            return -1
        else:
            return 1 + self.height(node.left)

            
