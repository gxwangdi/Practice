# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        stack = []
        node = root
        while node is not None or len(stack)>0:
            while node is not None:
                res.append(node.val)
                stack.append(node)
                node = node.left
            if len(stack)>0:
                node = stack.pop()
                node = node.right
        return res

        
