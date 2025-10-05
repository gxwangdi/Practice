import java.util.Arrays;

public class CountPrimes {
    /*
        Search online and found a similar approach, but more concise implementation.
        Based on https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes.
    */
    public int countPrimes(int n) {
        if (n<3) {
            return 0;
        }
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i=2; i*i<n; i++) {
            if (primes[i]) {
                for (int j=i+i; j<n; j+=i) {
                    primes[j] = false;
                }
            }
        }
        int count = 0;
        for (boolean b:primes) {
            if (b) {
                count++;
            }
        }
        return count;
    }
}
