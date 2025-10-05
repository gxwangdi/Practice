class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        if amount<1:
            return 0
        dp = [amount+1]*(amount+1)
        dp[0] = 0
        for coin in coins:
            for i in range(coin, amount+1):
                if dp[i-coin]!=amount+1:
                    dp[i] = min(dp[i], dp[i-coin]+1)
        if dp[amount] == amount+1:
            return -1
        return dp[amount]
        
