class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums == None or len(nums) == 0:
            return -1
        res=0
        for i in range(len(nums)) :
            res = res ^ nums[i] ^ (i+1)
        return res
    
