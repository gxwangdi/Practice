class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if not nums or len(nums)<2:
            return False
        nums.sort();
        i=0
        size = len(nums)
        while i<size-1:
            if nums[i] == nums[i+1]:
                return True
            i+=1
        return False
    
