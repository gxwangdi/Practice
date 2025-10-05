class Solution:
    def max(self, i1, i2 : int) -> int:
        if i1 >= i2 :
            return i1
        return i2
    
    def lengthOfLongestSubstring(self, s: str) -> int:
        res = 0
        if s == None or len(s) == 0 :
            return res
        flag = [False] * 256
        start = 0
        length = len(s)
        i = 0
        while i<length :
            cur = s[i]
            curIdx = ord(cur)
            if flag[curIdx] == False :
                flag[curIdx] = True
                continue
            res = self.max(res, i-start)
            j = start
            while j < i :
                curj = s[j]
                curIdxj = ord(curj)
                if curj == cur :
                    start = j+1
                    break
                flag[curIdxj] = False
                j +=1
            i +=1
        res = self.max(res, length-start)
        return res

