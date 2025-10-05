
public class CheckSumOfSquareNumbers {
	/*
     * @param : the given number
     * @return: whether whether there're two integers
     */
    public boolean checkSumOfSquareNumbers(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b = c - (int)(a * a);
            if (binary_search(0, b, b))
                return true;
        }
        return false;
    }
    
    public boolean binary_search(long s, long e, int n) {
        if (s > e)
            return false;
        long mid = s + (e - s) / 2;
        if (mid * mid == n)
            return true;
        if (mid * mid > n)
            return binary_search(s, mid - 1, n);
        return binary_search(mid + 1, e, n);
    }
    
    // Fermat Theorem approach.
    // public boolean checkSumOfSquareNumbers(int c) {
    //     if (c < 0) {
    //         return false;
    //     }
        
    //     for (int i = 2; i * i <= c; i++) {
    //         int count = 0;
    //         if (c % i == 0) {
    //             while (c % i == 0) {
    //                 count++;
    //                 c /= i;
    //             }
    //             if (i % 4 == 3 && count % 2 != 0)
    //                 return false;
    //         }
    //     }
    //     return c % 4 != 3;
    // }
}
