class Solution(object):
    def bulbSwitch(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n<1:
            return 0
        res=1
        while res*res<=n :
            res+=1
        return res-1

        
