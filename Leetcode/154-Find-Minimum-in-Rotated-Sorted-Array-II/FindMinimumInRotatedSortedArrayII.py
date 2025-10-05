class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # if not nums or len(nums)==0:
        #     return 0
        res = nums[0]
        for i in nums:
            res = min(res, i)
        return res
    
