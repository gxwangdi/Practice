class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        if not nums or len(nums)<2:
            return
        cur=0
        left=0
        length=len(nums)
        right=length-1
        while left < length:
            while left<length and nums[left]==cur:
                left+=1
            while right>=0 and nums[right]!=cur:
                right-=1
            if left<right:
                self._swap(nums, left, right)
                left+=1
                right-=1
            else:
                right = length-1
                cur+=1

    def _swap(self, nums, i, j):
        nums[i], nums[j] = nums[j], nums[i]

        
