class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        cur = ord(t[0])
        for i in range(1, len(t)):
            cur = cur^ord(t[i])
        for c in s:
            cur = cur^ord(c)
        return chr(cur)
    
