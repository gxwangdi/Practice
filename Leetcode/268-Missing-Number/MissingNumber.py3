class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return -1
        res=0
        for i in range(len(nums)) :
            res = res ^ nums[i] ^ (i+1)
        return res

        
