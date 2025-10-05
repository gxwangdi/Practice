
public class BestTimeToBuyAndSellStockII {
	/**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
	public int maxProfit(int[] prices) {
		int profit = 0;
		if (prices == null || prices.length == 0) {
			return profit;
		}
		int min = prices[0];
		int cur = 1;
		while (cur < prices.length) {
			if (prices[cur] < prices[cur - 1]) {
				profit = profit + prices[cur - 1] - min;
				min = prices[cur];
			}
			cur++;
		}
		profit = profit + prices[cur - 1] - min;
		return profit;
	}
}
