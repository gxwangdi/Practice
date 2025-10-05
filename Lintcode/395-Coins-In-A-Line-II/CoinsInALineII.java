
public class CoinsInALineII {
	/**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
	public boolean firstWillWin(int[] values) {
		int n = values.length;
		int[] dp = new int[n + 1];
		boolean[] flag = new boolean[n + 1];
		int[] sum = new int[n + 1];

		int allSum = values[n - 1];
		sum[n - 1] = values[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			sum[i] += sum[i + 1] + values[i];
			allSum += values[i];
		}
		return allSum < 2 * MemorySearch(0, n, dp, flag, values, sum);
	}

	private int MemorySearch(int i, int n, int[] dp, boolean[] flag,
			int[] values, int[] sum) {
		if (flag[i]) { // If dp is init, avoid duplicate computing.
			return dp[i];
		}

		flag[i] = true;
		if (i == n) {
			dp[n] = 0; // for the ith, no coins left.
		} else if (i == n - 1) {
			dp[i] = values[i]; // values[n-1] is the only option.
		} else if (i == n - 2) {
			dp[i] = values[i] + values[i + 1]; // the max amount is the sum of
												// last two.
		} else {
			// What one can get as max, is what his compatitor can get for
			// taking the next one, or taking the next two together.
			dp[i] = sum[i]
					- Math.min(MemorySearch(i + 1, n, dp, flag, values, sum),
							MemorySearch(i + 2, n, dp, flag, values, sum));
		}
		return dp[i];
	}// end of MemorySearch
}
