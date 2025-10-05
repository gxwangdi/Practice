class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0
        res = 0
        for i in nums:
            res ^= i
        return res

