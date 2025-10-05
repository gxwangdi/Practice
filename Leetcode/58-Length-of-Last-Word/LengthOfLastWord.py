class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        res=0
        an=0
        for i in range(len(s)) :
            if s[i] == ' ':
                if res!=0:
                    an=res
                res=0
            else:
                res+=1
        if res!=0:
            return res
        return an
        
