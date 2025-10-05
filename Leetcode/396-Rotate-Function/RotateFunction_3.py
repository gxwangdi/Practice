class Solution:
    def maxRotateFunction(self, A: List[int]) -> int:
        F = 0
        sum = 0
        res = -sys.maxsize - 1;
        n = len(A)
        if n<=1:
            return 0
        for i in range(0,n):
            F += i*A[i]
            sum += A[i]
        if F>res:
            res = F
        for k in range(1, n):
            F += sum
            F -= n*A[n-k]
            if F>res:
                res = F
        return res

        
