
public class BestTimeToBuyAndSellStock {
	/**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
	public int maxProfit(int[] prices) {
		int max = 0;
		if (prices == null || prices.length < 2) {
			return max;
		}
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			max = Math.max(max, prices[i] - min);
		}
		return max;
	}
}
