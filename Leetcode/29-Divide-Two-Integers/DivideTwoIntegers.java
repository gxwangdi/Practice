public class DivideTwoIntegers {
    
    public int divide(int dividend, int divisor) {
        if (divisor == 1) // Trival case 1
            return dividend;
        
        // Use negative integers to avoid integer overflow
        if (dividend > 0)
            return -divide(-dividend, divisor);
        if (divisor > 0)
            return -divide(dividend, -divisor);
        
        if (dividend > divisor) // Trivial case 2
            return 0;
        
        if ((dividend == Integer.MIN_VALUE) && (divisor == -1)) 
            // Overflow case
            return Integer.MAX_VALUE;
        
        // Find the highest mult = (divisor * 2^shifts) which is <= dividend
        // by shifting mult to the left without causing an overflow.
        // At most (log2(|dividend|) - log2(|divisor|) + 1) iterations.
        int min_divisor = Integer.MIN_VALUE >> 1;
        int mult = divisor; // = divisor * 2^shifts
        int shifts = 0;
        while ((mult >= min_divisor) && (mult > dividend)) {
            mult <<= 1;
            ++shifts;
        }
        
        // Compute the result by shifting mult to the right.
        // At most (log2(|dividend|) - log2(|divisor|) + 1) iterations for the outer loop.
        // At most (log2(|dividend|) - log2(|divisor|) + 1) iterations for the inner loop
        // (in total, not per outer iteration).
        int result = 0;
        int power = 1 << shifts; // = 2^shifts
        while (dividend <= divisor) {
            shifts = 0;
            while (mult < dividend) {
                mult >>= 1;
                ++shifts;
            }
            dividend -= mult;
            power >>= shifts;
            result |= power; // Adds power to result
        }
        
        return result;
    }
    
    /*    
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return dividend>=0?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        if (divisor == -1) {
            if (dividend == Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        if (divisor == 1) {
            return dividend;
        }
        
        long dvd = dividend<0?-dividend:dividend;
        long dvs = divisor<0?-divisor:divisor;
        
        if (dvd < dvs) {
            return 0;
        }
        
        boolean isPositive = true;
        if (dividend < 0) {
            isPositive = !isPositive;
        }
        if (divisor < 0) {
            isPositive = !isPositive;
        }
        
        int result = 0;
        while (dvd >= dvs) {
            int shift = 0;
            while (dvd>=(dvs<<shift)) {
                shift++;
            }
            dvd -= dvs << (shift - 1);
            result += 1 << (shift - 1);
        }
        if (!isPositive) {
            result = -result;
        }
        return result;
    }
    */
}



