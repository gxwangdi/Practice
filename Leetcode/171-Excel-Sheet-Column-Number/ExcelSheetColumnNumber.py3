class Solution:
    def titleToNumber(self, s: str) -> int:
        if s == None:
            return -1
        length = len(s)
        if length < 1:
            return 0;
        total = 0
        i = 0
        while i<length :
            total *= 26
            total += ord(s[i])-ord('A') + 1
            i+=1
        return total
