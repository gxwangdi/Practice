class Solution(object):
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        res = [1] + [0] * rowIndex
        for i in range(rowIndex):
            res[0] = 1
            for j in range(i+1, 0, -1): # Get next line
                res[j] = res[j] + res[j-1]
        return res
    
    # def getRow(self, rowIndex):
    #     """
    #     :type rowIndex: int
    #     :rtype: List[int]
    #     """
    #     res = [1] * (rowIndex+1)
    #     for i in range(1, rowIndex/2+1):
    #         res[i] = res[rowIndex-i] = res[i-1] * (rowIndex-i+1) / i
    #     return res
