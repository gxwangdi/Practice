# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution(object):
    def findTilt(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        tilt = [0]
        def _postOrder(node, tilt):
            if not node:
                return 0
            left = _postOrder(node.left, tilt)
            right = _postOrder(node.right, tilt)
            tilt[0] = tilt[0] + abs(left - right)
            return left + right + node.val
        _postOrder(root, tilt)
        return tilt[0]
