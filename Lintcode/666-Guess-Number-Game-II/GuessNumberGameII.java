public class GuessNumberGameII {
	/**
	 * @param n an integer
	 * @return how much money you need to have to guarantee a win
	 */
	public int getMoneyAmount(int n) {
		if (n == 1) {
			return 0;
		}
		int[][] dp = new int[n + 1][n + 1];

		for (int len = 1; len <= n - 1; len++) {
			for (int i = 1; i + len <= n; i++) {
				int j = i + len;
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i; k <= j; k++) {
					dp[i][j] = Math.min(
							dp[i][j],
							k + Math.max(k == i ? 0 : dp[i][k - 1],
										 k == j ? 0 : dp[k + 1][j]));
				}
			}
		}
		return dp[1][n];
	}
}
