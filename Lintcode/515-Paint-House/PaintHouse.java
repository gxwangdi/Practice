
public class PaintHouse {
	/**
	 * @param costs
	 *            n x 3 cost matrix
	 * @return an integer, the minimum cost to paint all houses
	 */
	public int minCost(int[][] costs) {
		if (costs == null || costs.length == 0) {
            return 0;
        }
		
		int[][] dp = new int[costs.length][3];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < 3; j++)
				dp[i][j] = costs[i][j];
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < 3; j++) {
				dp[i][j] += Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
				// System.out.println(i + ":" + j + ":" + dp[i][j]);
			}
		}
		return Math.min(dp[dp.length - 1][0], Math.min(dp[dp.length - 1][1], dp[dp.length - 1][2]));
	}
}
