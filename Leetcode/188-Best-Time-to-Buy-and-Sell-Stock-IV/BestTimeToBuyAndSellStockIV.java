public class BestTimeToBuyAndSellStockIV {
    
    // DP: t(i,j) is the max profit for up to i transactions by time j (0<=i<=K, 0<=j<=T).
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return solveMaxProfit(prices);
        
        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax); 
                // 有i次交易 到第j-1天时候的最大值， 以及第j天时候的价格和累积最小成本的最大值 max取后者表明我要在第j天进行交易
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);  
                // 少一次交易少一天时候的最大值＋当前最小成本， max取后者表明交易算上那一天  因为那是最小成本
            }
        }
        return t[k][len - 1];
    }
    
    /*
    public int maxProfit(int k, int[] prices) {
        if (k<=0 || prices == null || prices.length == 0) {
            return 0;
        }
        
        if (k>=prices.length/2) {  // One transaction is buy and sell.    
            return solveMaxProfit(prices); 
        }
        
        int[] g = new int[k+1];
        int[] l = new int[k+1];
        for (int i=0; i<prices.length-1; i++) {
            int diff = prices[i+1] - prices[i];
            for (int j=k; j>=1; j--) {
                l[j] = Math.max(g[j-1] + Math.max(diff, 0), l[j] + diff);
                g[j] = Math.max(g[j], l[j]);
            }
        }
        return g[k];
    }
    */
    
    // Sell and buy stock II
    private int solveMaxProfit(int[] prices) {
        int max = 0;
        for (int i=1; i<prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                max += prices[i] - prices[i-1];
            }
        }
        return max;
    }// end of solveMaxProfit     
}



