class Solution(object):
    def isSubsequence(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if not s or not t or len(s) > len(t):
            return False
        ls = len(s)
        lt = len(t)
        i = 0
        j = 0
        while i<ls and j<lt:
            if s[i]==t[j]:
                i+=1
            j+=1
        return i == ls
    
