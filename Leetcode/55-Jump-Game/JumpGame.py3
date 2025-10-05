class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if nums == None or len(nums)==0 :
            return False
        size = len(nums)
        dp = [False]*size
        dp[0] = True
        cur = 0
        for i in range(size) :
            if dp[i] == False :
                return False
            far = i + nums[i]
            if far >= size - 1:
                return True
            if far < cur:
                continue
            while cur <= far:
                dp[cur] = True
                cur+=1

        return dp[-1]
        
