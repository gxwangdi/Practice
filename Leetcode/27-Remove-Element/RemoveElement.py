class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        if nums == None or len(nums) == 0:
            return 0
        i=0
        j=0
        length = len(nums)
        while j < length :
            if nums[j]!=val :
                nums[i] = nums[j]
                i+=1
            j+=1
        return i

