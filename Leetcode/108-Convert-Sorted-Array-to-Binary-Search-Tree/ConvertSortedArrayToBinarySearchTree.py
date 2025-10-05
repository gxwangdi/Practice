# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        if len(nums)==0:
            return None
        return self.getBalanceBST(nums, 0, len(nums)-1)

    def getBalanceBST(self, nums, start, end):
        """
        :type nums: List[int]
        :type start: int
        :type end: int
        :rtype: TreeNode
        """
        if start > end:
            return None
        mid = start+(end-start)/2
        root = TreeNode(nums[mid])
        if start == end:
            return root
        root.left = self.getBalanceBST(nums, start, mid-1)
        root.right = self.getBalanceBST(nums, mid+1, end)
        return root
    
