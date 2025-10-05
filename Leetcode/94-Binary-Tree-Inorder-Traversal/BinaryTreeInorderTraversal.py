# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []
        stack = []
        p = root
        while p is not None or len(stack)>0:
            while p is not None:
                stack.append(p)
                p = p.left
            if len(stack)>0:
                p = stack.pop()
                res.append(p.val)
                p = p.right
        return res
