class Solution(object):
    def trailingZeroes(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n<0 :
            return -1
        ans = 0
        while n>0 :
            n = n/5
            ans += n
        return ans
        
