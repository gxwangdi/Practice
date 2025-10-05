
public class UniquePaths {
	/**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
	public int uniquePaths(int m, int n) {
		m--;
		n--;
		if (m <= 0 || n <= 0) {
			return 1;
		}

		int r = Math.min(m, n);
		long result = 1;
		for (int i = 1; i <= r; i++) {
			result = result * (m + n - i + 1);
			result = result / i;
		}
		return (int) result;
	}
}
