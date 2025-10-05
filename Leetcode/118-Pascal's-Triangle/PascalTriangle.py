class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        if numRows == 0:
            return []
        res = [[1]]
        for i in range(1, numRows):
            res.append([]) # init res[1~numRows]
            for j in range(i+1):
                res[i].append((res[i-1][j-1] if j>0 else 0) + (res[i-1][j] if j<i else 0))
        return res

# My solution, need to get the type in-sensitive nature of python2.
# class Solution(object):
#     def generate(self, numRows):
#         """
#         :type numRows: int
#         :rtype: List[List[int]]
#         """
#         res = [[]]
#         if numRows < 1:
#             return res
#         row = 1
#         while row <= numRows:
#             list = []
#             j = 0
#             while j<row:
#                 if j==0 or j==row-1:
#                     list.append(1)
#                     j+=1
#                     continue
#                 if row>2:
#                     list.append(res[row-2][j-1] + res[row-2][j])

#                 j+=1
#             res.append(list)
#             row+=1
#         return res
