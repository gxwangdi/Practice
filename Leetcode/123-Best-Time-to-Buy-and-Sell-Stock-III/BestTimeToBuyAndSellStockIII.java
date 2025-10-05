public class BestTimeToBuyAndSellStockIII {
    
    // l[i] means the max profit for [0...i]  r[i] means the max profit for [i...n]
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int max = 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        
        process(prices, left, right);
        for (int i=0; i<prices.length; i++) {
            max = Math.max(max, left[i] + right[i]);
        }
        return max;
    }
    
    
    private void process(int[] prices, int[] left, int[] right) {
        left[0] = 0;
        int min = prices[0];
        
        for (int i=1; i<left.length; i++) {
            left[i] = Math.max(left[i-1], prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        
        right[right.length-1] = 0;
        int max = prices[right.length-1];
        for (int i=right.length-2; i>=0; i--) {
            right[i] = Math.max(right[i+1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }
    }
    
    
    /*
    // Naive approach, accepted on lintcode, TLE on leetcode.
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices == null || prices.length == 0) {
            return maxProfit;
        }
        
        int[] dp = new int[prices.length];
        int profit;
        for (int i=0; i<prices.length; i++) {
            profit = maxProfit(prices, 0, i);
            profit+= maxProfit(prices, i+1, prices.length-1);
            dp[i] = profit;
        }
        
        for (int i:dp) {
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
    */
}




