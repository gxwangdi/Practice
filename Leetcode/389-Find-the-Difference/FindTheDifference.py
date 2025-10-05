class Solution(object):
    def findTheDifference(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        cur = ord(t[0])
        for i in range(1, len(t)):
            cur = cur^ord(t[i])
        for c in s:
            cur = cur^ord(c)
        return chr(cur)
    
