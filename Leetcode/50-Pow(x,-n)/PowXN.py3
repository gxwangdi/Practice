class Solution:
    def myPow(self, x: float, n: int) -> float:
        if x == 1.0:
            return 1.0
        if n<0:
            return 1/self.power(x, -n)
        else:
            return self.power(x, n)

    def power(self, x: float, n: int) -> float:
        if n==0:
            return 1
        v = self.power(x, n//2)
        if n%2 == 0:
            return v*v
        else:
            return v*v*x
