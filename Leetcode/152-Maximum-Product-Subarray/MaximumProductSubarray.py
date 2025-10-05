class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is not None and len(nums)==0:
            return 0

        maxProduct = nums[0]
        maxTemp = 1
        minTemp = 1

        for i in range(len(nums)):
            a = maxTemp*nums[i]
            b = minTemp*nums[i]
            maxTemp = max(max(a,b), nums[i])
            minTemp = min(min(a,b), nums[i])
            maxProduct = max(maxProduct, maxTemp)
        return maxProduct
        
