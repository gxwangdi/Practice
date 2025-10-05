class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums == None or len(nums) == 0 :
            return -1
        size = len(nums)
        if size == 1 :
            return 0

        dp = [sys.maxint]*size
        dp[0] = 0
        cur = 1
        for i in range(size) :
            far = i + nums[i]
            value = dp[i] + 1
            if far >= size -1:
                return value
            if far < cur :
                continue
            while cur <= far:
                dp[cur] = value
                cur+=1
        return dp[-1]
