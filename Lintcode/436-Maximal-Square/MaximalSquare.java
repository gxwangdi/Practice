public class MaximalSquare {
	/**
	 * @param matrix: a matrix of 0 and 1
	 * @return: an integer
	 */
	public int maxSquare(int[][] matrix) {
		int max = 0;
		if (matrix == null || matrix.length == 0) {
			return max;
		}
		int m = matrix.length;
		int n = matrix[0].length;

		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 1) {
				dp[i][0] = 1;
				max = Math.max(max, dp[i][0]);
			} else {
				dp[i][0] = 0;
			}
		}

		for (int j = 0; j < n; j++) {
			if (matrix[0][j] == 1) {
				dp[0][j] = 1;
				max = Math.max(max, dp[0][j]);
			} else {
				dp[0][j] = 0;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					dp[i][j] = 0;
					continue;
				}

				dp[i][j] = Math.min(dp[i - 1][j - 1],
						Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				max = Math.max(max, dp[i][j]);
			}
		}
		return max * max;
	}
}
