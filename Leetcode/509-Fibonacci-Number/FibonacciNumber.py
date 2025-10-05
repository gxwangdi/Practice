class Solution(object):
    def fib(self, N):
        """
        :type N: int
        :rtype: int
        """
        if N<0:
            return -1
        if N<2:
            return N
        dp = [0,1]
        for i in range(2, N+1, 1):
            dp[i%2] = dp[(i-1)%2] + dp[(i-2)%2]
        return dp[N%2]
    
