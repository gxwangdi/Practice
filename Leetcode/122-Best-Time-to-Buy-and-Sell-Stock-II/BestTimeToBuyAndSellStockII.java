public class BestTimeToBuyAndSellStockII {

  public int maxProfit(int[] prices) {
        var profit = 0;
        for(int i=0; i+1<prices.length; i++) {
            if (prices[i] < prices[i+1]) {
                profit += prices[i+1]-prices[i];
            }
        }
        return profit;
    }
    
    // public int maxProfit(int[] prices) {
    //     int profit = 0;
    //     if (prices == null || prices.length == 0) {
    //         return profit;
    //     }
    //     int min = prices[0];
    //     int cur = 1;
    //     while (cur < prices.length) {
    //         if (prices[cur] < prices[cur-1]) {
    //             profit = profit + prices[cur-1] - min;
    //             min = prices[cur];
    //         }
    //         cur++;
    //     }
    //     profit = profit + prices[cur-1] - min;
    //     return profit;
    // }
}
