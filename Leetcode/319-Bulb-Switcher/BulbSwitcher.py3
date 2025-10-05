class Solution:
    def bulbSwitch(self, n: int) -> int:
        if n<1:
            return 0
        res=1
        while res*res<=n :
            res+=1
        return res-1
