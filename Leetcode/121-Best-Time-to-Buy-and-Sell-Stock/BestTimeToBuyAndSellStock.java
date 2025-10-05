public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <2) {
            return 0;
        }

        int profit = 0;
        int min = prices[0];
        for (int i=0; i<prices.length; i++) {
            profit = Math.max(profit, prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }// end of maxProfit

    // public int maxProfit(int[] prices) {
    //     var minPrice = Integer.MAX_VALUE;
    //     var maxProfit = 0;
    //     for(int price : prices) {
    //         if (price < minPrice) {
    //             minPrice = price;
    //         } else if (price - minPrice > maxProfit) {
    //             maxProfit = price - minPrice;
    //         }
    //     }
    //     return maxProfit;
    }
}
