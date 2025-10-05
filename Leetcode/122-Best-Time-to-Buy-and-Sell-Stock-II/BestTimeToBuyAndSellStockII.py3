class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        if len(prices)<2:
            return profit
        cost = prices[0]
        cur = 1
        while cur<len(prices):
            if prices[cur] < prices[cur-1]:
                profit = profit + prices[cur-1] - cost
                cost = prices[cur]
            cur+=1
        profit = profit + prices[cur-1] - cost
        return profit
    
