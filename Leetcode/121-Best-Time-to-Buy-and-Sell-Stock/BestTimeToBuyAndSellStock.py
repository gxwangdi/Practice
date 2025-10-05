class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices) <2:
            return 0;
        profit = 0
        cost = prices[0]
        for i in range(len(prices)):
            profit = max(profit, prices[i]-cost)
            cost = min(cost, prices[i])
        return profit
        
