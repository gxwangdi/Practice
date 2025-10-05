class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if not nums or len(nums)<2:
            return
        slow=0
        fast=0
        size=len(nums)
        while fast < size:
            if nums[fast]==0:
                fast+=1
                continue
            nums[slow] = nums[fast]
            slow+=1
            fast+=1
        while slow < size:
            nums[slow] =0
            slow+=1

    
