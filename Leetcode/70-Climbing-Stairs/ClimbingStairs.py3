class Solution:
    def climbStairs(self, n: int) -> int:
        if n<=0 :
            return 0
        if n<3 :
            return n
        dp = [0] * 2
        dp[0] = 1
        dp[1] = 2
        i = 2
        while i<n :
            dp[i%2] = dp[(i-1)%2] + dp[(i-2)%2]
            i+=1
        return dp[(n-1)%2]
        
