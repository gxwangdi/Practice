
public class DivideTwoIntegers {
	/**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
	public int divide(int dividend, int divisor) {
		if (divisor == 1) {
			return dividend;
		}
		// Use negative integers to avoid integers overflow
		if (dividend > 0) {
			return -divide(-dividend, divisor);
		}
		if (divisor > 0) {
			return -divide(dividend, -divisor);
		}

		if (dividend > divisor) {
			return 0;
		}

		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}

		int min_divisor = Integer.MIN_VALUE >> 1;
		int mult = divisor;// = divisor * 2^shifts
		int shifts = 0;
		while (mult >= min_divisor && mult > dividend) {
			mult = mult << 1;
			shifts++;
		}
		int result = 0;
		int power = 1 << shifts; // = 2^shifts;
		while (dividend <= divisor) {
			shifts = 0;
			while (mult < dividend) {
				mult = mult >> 1;
				shifts++;
			}
			dividend = dividend - mult;
			power = power >> shifts;
			result = result | power;
		}
		return result;
	}
    
    /*
    public int divide(int dividend, int divisor) {
        // Write your code here
        if (divisor == 0) {
            return dividend>=0?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        
        if (dividend == 0) {
            return 0;
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
        
        boolean isNegative = (dividend < 0 && divisor > 0) || 
                             (dividend > 0 && divisor < 0);
        long a = Math.abs(dividend);
        long b = Math.abs(divisor);
        int result = 0;
        while (a >= b) {
            int shift = 0;
            while (a>=(b<<shift)) {
                shift++;
            }
            a -= b << (shift - 1);
            result += 1 << (shift - 1);
        }
        return isNegative? -result:result;
    }
    */
}
