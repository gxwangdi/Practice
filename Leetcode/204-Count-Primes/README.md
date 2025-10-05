
There are couple of probabilistic primality test algorithm.  BigInteger.isProbablePrime() provides implementation for one of them.  

For accumulating all primes under some certain value, we can find new primes based on what we have found as primes.    Try to divide all primes found up to Math.sqrt(n) and you can see if it is a prime.     

Space O(n),    Time O(nlogn).   