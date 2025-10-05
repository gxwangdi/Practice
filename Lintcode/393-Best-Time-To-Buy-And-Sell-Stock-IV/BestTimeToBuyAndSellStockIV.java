
public class BestTimeToBuyAndSellStockIV {
	/**
	 * @param k: An integer
	 * @param prices: Given an integer array
	 * @return: Maximum profit
	 */
	public int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int len = prices.length;
		if (k >= len / 2) {
			return maxProfit2(prices);
		}

		int[][] dp = new int[k + 1][len];
		for (int i = 1; i <= k; i++) {
			// Buying at day 0.
			int tmpMax = -prices[0];
			for (int j = 1; j < len; j++) {
				// If taking prices[j] + tmpMax, it means sell at day j.
				dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmpMax);
				// If taking dp[i-1][j-1] - prices[j], it means buy at day j.
				tmpMax = Math.max(tmpMax, dp[i - 1][j - 1] - prices[j]);
			}
		}
		return dp[k][len - 1];
	}

	// This is for best time to buy and sell stock II
	private int maxProfit2(int[] prices) {
		int profit = 0;
		int len = prices.length;
		for (int i = 1; i < len; i++) {
			if (prices[i] > prices[i - 1]) {
				profit += prices[i] - prices[i - 1];
			}
		}
		return profit;
	}
}
