import java.util.ArrayList;
import java.util.List;

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n <= 0 || primes == null || primes.length == 0) {
            return 0;
        }
        int[] index = new int[primes.length];
        List<Integer> res = new ArrayList<>();
        res.add(1);
        int cur = 2;
        while (res.size() < n) {
            int min = Integer.MAX_VALUE;
            for (int i=0; i<primes.length; i++) {
                while (primes[i]*res.get(index[i])<cur ) {
                    index[i]++;
                }
                min = Math.min(min, primes[i]*res.get(index[i]));
            }
            res.add(min);
            cur = min+1;
        }
        return res.get(n-1);
    }
}







