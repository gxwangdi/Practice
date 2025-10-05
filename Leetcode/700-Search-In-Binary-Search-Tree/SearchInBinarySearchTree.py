# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def searchBST(self, root, val):
        """
        :type root: TreeNode
        :type val: int
        :rtype: TreeNode
        """
        cur = root
        while cur:
            if cur.val == val:
                break
            if cur.val > val:
                cur = cur.left
                continue
            cur = cur.right
        return cur

        
