class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        """
        :type ransomNote: str
        :type magazine: str
        :rtype: bool
        """
        if len(ransomNote) > len(magazine):
            return False

        count = [0]*26
        for c in magazine:
            count[ord(c)-97]+=1

        for c in ransomNote:
            index = ord(c)-97
            count[index]-=1
            if count[index]<0:
                return False
        return True
