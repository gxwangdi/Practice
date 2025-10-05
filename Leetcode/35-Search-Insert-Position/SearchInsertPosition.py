class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if nums == None or len(nums) == 0:
            return 0
        start = 0
        end = len(nums)-1
        while start < end :
            mid = start + (end-start)/2
            if nums[mid] == target:
                return mid
            if nums[mid] > target:
                end = mid-1
            else:
                start = mid+1

        # start == end
        if nums[start] < target:
            return start+1
        return start
