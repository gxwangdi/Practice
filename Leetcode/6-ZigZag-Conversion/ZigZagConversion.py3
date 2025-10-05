class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if len(s) <= numRows or numRows <2:
            return s
        sb = ""
        size = 2*numRows-2;
        for i in range(numRows) :
            for j in range(i, len(s), size) :
                sb += s[j]
                if i!=0 and i!= numRows-1 :
                    temp = j+size-2*i
                    if temp < len(s) :
                        sb += s[temp]
        return sb
        
