class Solution:
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix or len(matrix)==0 or len(matrix[0])==0:
            return False

        i=0
        j=len(matrix[0])-1
        length=len(matrix)
        while i< length and j>=0:
            temp = matrix[i][j]
            if temp == target:
                return True
            elif temp > target:
                j-=1
            else:
                i+=1
        return False

    
