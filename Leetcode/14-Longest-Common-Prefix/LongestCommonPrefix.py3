class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if strs == None or len(strs) == 0:
            return ""
        if len(strs) == 1:
            return strs[0]
        for i in range(len(strs[0])):
            c = strs[0][i]
            for str in strs:
                if i < len(str) and c==str[i]:
                    continue
                return str[0:i]

        return strs[0]

        
