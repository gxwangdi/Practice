class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        left = 0
        right = x
        while left+1<right :
            mid = left +(right-left)/2
            t = mid*mid
            if t==x:
                return mid
            if t<x:
                left = mid
            else:
                right = mid
        t = right*right
        if t>x :
            return left
        return right
