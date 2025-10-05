class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m<=0 or n<=0:
            return 0
        N = n+m-2
        k = m-1
        res=1.0
        for i in range(1, k+1):
            res = res * (N - k + i) / i
        return int(res)
    
