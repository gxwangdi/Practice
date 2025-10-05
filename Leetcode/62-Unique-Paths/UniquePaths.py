class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        if m<=0 or n<=0:
            return 0
        N = n+m-2
        k = m-1
        res=1.0
        for i in range(1, k+1):
            res = res * (N - k + i) / i
        return int(res)

    
