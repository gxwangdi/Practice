class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
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
