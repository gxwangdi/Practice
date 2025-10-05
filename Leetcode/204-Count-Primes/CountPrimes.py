class Solution(object):
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n<3:
            return 0
        primes = [True]*n
        primes[0] = False
        primes[1] = False
        i=2
        while i*i<n:
            if primes[i]:
                j = i+i
                while j<n:
                    primes[j]=False
                    j+=i
            i+=1
        count=0
        for b in primes:
            if b:
                count+=1
        return count
    
