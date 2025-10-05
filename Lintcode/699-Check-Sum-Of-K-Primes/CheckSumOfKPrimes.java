import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckSumOfKPrimes {
	/*
	 * @param : an int
	 * 
	 * @param : an int
	 * 
	 * @return: if N can be expressed in the form of sum of K primes, return true;
	 * otherwise, return false.
	 */
	// MLE
//	public boolean isSumOfKPrimes(int n, int k) {
//		if (k > n / 2) {
//			return false;
//		}
//		List<Integer> primes = sieveOfEratosthenes(n);
//		boolean result = false;
//		for (int i = 0; i < primes.size(); i++) {
//			result |= isSumOfKPrimesRecursive(n - primes.get(i), k - 1, sieveOfEratosthenes(n - primes.get(i)));
//		}
//		return result;
//	}
//
//	private boolean isSumOfKPrimesRecursive(int n, int k, List<Integer> primes) {
//		System.out.println("n:" + n + ", k:" + k);
//		printPrimeList(primes);
//		if (n < 0 || k < 0 || k > n / 2) {
//			return false;
//		}
//		if (k == 0) {
//			return n == 0;
//		}
//		boolean result = false;
//		for (int i = 0; i < primes.size(); i++) {
//			result |= isSumOfKPrimesRecursive(n - primes.get(i), k - 1, sieveOfEratosthenes(n - primes.get(i)));
//		}
//		return result;
//	}
//
//	private void printPrimeList(List<Integer> primes) {
//		for (Integer i : primes) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//	}
//
//	// Given n, find all primes less than or equal to n.
//	private List<Integer> sieveOfEratosthenes(int n) {
//		// Create a boolean array "prime[0..n]" and initialize
//		// all entries it as true. A value in prime[i] will
//		// finally be false if i is Not a prime, else true.
//		boolean prime[] = new boolean[n + 1];
//		Arrays.fill(prime, true);
//		// for(int i=0;i<n;i++)
//		// prime[i] = true;
//
//		for (int p = 2; p <= n; p++) {
//			// If prime[p] is not changed, then it is a prime
//			if (prime[p] == true) {
//				// Update all multiples of p
//				for (int i = p * 2; i <= n; i += p)
//					prime[i] = false;
//			}
//		}
//
//		// collect all prime numbers
//		List<Integer> result = new ArrayList<>();
//		for (int i = 2; i <= n; i++) {
//			if (prime[i] == true) {
//				result.add(i);
//			}
//		}
//		return result;
//	}
	
	// Checking if a number is prime or not
    private boolean isprime(int x)
    {
        // check for numbers from 2 to sqrt(x)
        // if it is divisble return false
        for (int i=2; i*i<=x; i++)
            if (x%i == 0)
             
                return false;
        return true;
    }
     
    // Returns true if N can be written as sum
    // of K primes
    public boolean isSumOfKPrimes(int N, int K)
    {
        // N < 2K directly return false
        if (N < 2*K)
            return false;
         
        // If K = 1 return value depends on primality of N
        if (K == 1)
            return isprime(N);
             
        if (K == 2)
        {
            // if N is even directly return true;
            if (N%2 == 0)
                return true;
                 
            // If N is odd, then one prime must
            // be 2. All other primes are odd
            // and cannot have a pair sum as even.
            return isprime(N - 2);
        }
         
        // If K >= 3 return true;
        return true;
    }
}


