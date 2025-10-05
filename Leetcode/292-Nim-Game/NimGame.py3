class Solution:
    def canWinNim(self, n: int) -> bool:
        if n < 0:
            return False

        return n%4!=0
