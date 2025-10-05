class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        # upper = 2**31-1
        upper = pow(2, 31)-1
        m = abs(x)
        if m > upper :
            return 0
        total = 0
        while m > 0 :
            mod = m%10
            total = total*10+mod
            m = m/10
        if total > upper :
            return 0
        if x < 0 :
            total *= -1
        return total
