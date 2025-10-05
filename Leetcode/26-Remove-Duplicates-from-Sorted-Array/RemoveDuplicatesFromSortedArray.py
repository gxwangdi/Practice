class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        i = 0
        if nums == None or len(nums) <1 :
            return i
        j = i+1
        cur = nums[i]
        length = len(nums)
        while j < length :
            if nums[j] != cur :
                i+=1;
                nums[i] = nums[j]
                cur = nums[i]
            j+=1
        return i+1
        
