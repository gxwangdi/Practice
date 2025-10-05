
public class Triangle {
	/**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
	public int minimumTotal(int[][] triangle) {
		if (triangle == null || triangle.length == 0) {
			return 0;
		}
		int n = triangle.length;
		int[][] dp = sameSizeOf(triangle);
		dp[0][0] = triangle[0][0];
		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i - 1][0] + triangle[i][0];
			dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
		}

		for (int i = 2; i < n; i++) {
			for (int j = 1; j < i; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1])
						+ triangle[i][j];
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			min = Math.min(dp[n - 1][i], min);
		}
		return min;
	}

	private int[][] sameSizeOf(int[][] src) {
		int[][] res = new int[src.length][];
		for (int i = 0; i < src.length; i++) {
			res[i] = new int[src[i].length];
		}
		return res;
	}
}
