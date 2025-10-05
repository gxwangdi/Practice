class Solution:
    def trailingZeroes(self, n: int) -> int:
        if n<0 :
            return -1
        ans = 0
        while n>0 :
            n = n//5
            ans += n
        return ans

