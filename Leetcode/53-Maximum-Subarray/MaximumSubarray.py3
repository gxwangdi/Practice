class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0 :
            return 0

        res = -sys.maxsize-1
        numSum = 0
        for i in nums:
            numSum += i;
            res = max(res, numSum)
            numSum = max(numSum, 0)
        return res
        
