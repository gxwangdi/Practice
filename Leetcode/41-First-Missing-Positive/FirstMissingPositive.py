class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums == None or len(nums) == 0:
            return 1
        size = len(nums)
        i = 0
        while i < size :
            if nums[i] <= 0:
                i+=1
                continue
            if nums[i] > size:
                i+=1
                continue
            if nums[nums[i]-1] == nums[i]:
                i+=1
                continue
            temp = nums[i]
            nums[i], nums[temp-1] = nums[temp-1], nums[i]

        i = 0
        while i<size:
            if nums[i] != i+1 :
                return i+1
            i+=1
        return size + 1
