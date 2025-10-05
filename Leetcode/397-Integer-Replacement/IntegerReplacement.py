class Solution(object):
    def integerReplacement(self, n):
        """
        :type n: int
        :rtype: int
        """
        count=0
        while n!=1:
            small = n&(n-1)
            big = n&(n+1)
            if (n&1) ==0:
                n>>=1
            elif (small&(small-1)) <= (big&(big-1)):
                n-=1
            else:
                n+=1
            count+=1
        return count
