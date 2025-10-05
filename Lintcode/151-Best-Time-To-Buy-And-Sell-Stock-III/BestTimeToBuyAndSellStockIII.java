
public class BestTimeToBuyAndSellStockIII {
	/**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices == null || prices.length == 0) {
            return maxProfit;
        }
        int[] dp = new int[prices.length];
        int profit;
        for (int i=0; i<prices.length; i++) {
            profit = maxProfit(prices, 0, i);
            profit += maxProfit(prices, i+1, prices.length-1);
            dp[i] = profit;
        }
        
        for (int i : dp) {
            maxProfit = Math.max(maxProfit, i);
        }
        return maxProfit;
    }
    
    private int maxProfit(int[] src, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int profit = 0;
        int min = src[start];
        while (start <= end) {
            min = Math.min(min, src[start]);
            profit = Math.max(profit, src[start]-min);
            start++;
        }
        return profit;
    }
}
