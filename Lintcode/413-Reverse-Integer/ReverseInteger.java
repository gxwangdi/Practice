
public class ReverseInteger {
	/**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
	public int reverseInteger(int n) {
		boolean isPositive = true;
		if (n < 0) {
			isPositive = false;
		}
		int m = Math.abs(n);
		long res = 0;
		while (m > 0) {
			res = res * 10 + m % 10;
			m = m / 10;
		}
		if (res > Integer.MAX_VALUE) {
			return 0;
		}
		if (!isPositive) {
			res *= -1;
		}
		return (int) res;
	}
}
