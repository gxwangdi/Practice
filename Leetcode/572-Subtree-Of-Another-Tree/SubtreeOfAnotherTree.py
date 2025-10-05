# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSubtree(self, s, t):
        """
        :type s: TreeNode
        :type t: TreeNode
        :rtype: bool
        """
        if self._isSameTree(s, t):
            return True
        if not s:
            return False
        return self.isSubtree(s.left, t) or self.isSubtree(s.right, t)

    def _isSameTree(self, s, t):
        if not s and not t:
            return True
        if not s or not t:
            return False
        if s.val != t.val:
            return False
        return self._isSameTree(s.left, t.left) and self._isSameTree(s.right, t.right)
