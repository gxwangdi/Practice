public class BestTimeToBuyAndSellStockWithCooldown {
    
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        // buy[1] = Math.max(-prices[0], -prices[1]);
        // buy[1] = buy[0];
        
        for (int i=1; i<prices.length; i++) {
            int temp;
            if (i>=2) {
                temp = sell[i-2];
            } else {
                temp = 0;
            }
            buy[i] = Math.max(buy[i-1], temp-prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }
        return sell[prices.length-1];
    }
    
    /*
    public int maxProfit(int[] prices) {
    if(prices == null || prices.length <= 1) return 0;
  
    int b0 = -prices[0];
    int b1 = b0;
    int s0 = 0, s1 = 0, s2 = 0;
 
    for(int i = 1; i < prices.length; i++) {
    	b0 = Math.max(b1, s2 - prices[i]);
    	s0 = Math.max(s1, b1 + prices[i]);
    	b1 = b0; s2 = s1; s1 = s0; 
    }
    return s0;
    }
    */
}




