class Solution:
    def validPalindrome(self, s: str) -> bool:
        return self.valid(s, 0, len(s)-1, 0)
    
    def valid(self, s:str, left:int, right:int, times:int) -> bool:
        """
        :type s: str
        :type left: int
        :type right: int
        :type times: int
        :rtype: bool
        """
        while left < right :
            if s[left] != s[right] :
                if times < 1:
                    return self.valid(s, left+1, right, times+1) or self.valid(s, left, right-1, times+1)
                return False
            left+=1
            right-=1
        return True
