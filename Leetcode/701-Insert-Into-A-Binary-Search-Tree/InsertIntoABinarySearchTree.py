# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def insertIntoBST(self, root, val):
        """
        :type root: TreeNode
        :type val: int
        :rtype: TreeNode
        """
        node = TreeNode(val)
        if not root:
            root = node
            return root
        cur = root
        while True:
            if cur.val > val:
                if not cur.left:
                    cur.left = node
                    break
                cur = cur.left
                continue
            if not cur.right:
                cur.right = node
                break
            cur = cur.right
        return root
