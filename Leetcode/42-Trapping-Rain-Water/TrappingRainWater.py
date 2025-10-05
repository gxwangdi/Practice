class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        total = 0
        if not height or len(height)<3:
            return total

        length = len(height)
        left = [0]*length
        right = [0]*length

        m = height[0]
        for i in range(1, length):
            left[i] = max(m, height[i-1])
            m = max(m, height[i])

        m = height[length-1]
        for i in range(length-2, 0, -1):
            right[i] = max(m, height[i+1])
            m = max(m, height[i])

        s = 0
        for i in range(1, length-1):
            s = min(left[i], right[i])-height[i]
            if s>0:
                total += s
        return total
    
