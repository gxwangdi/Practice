class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        int dp[amount+1];
        for (int i=0; i<amount+1; i++) {
            dp[i] = amount+1;
        }
        dp[0] = 0;
        for (int j=0; j<coins.size(); j++) {
            int coin = coins[j];
            for (int i=coin; i<=amount; i++) {
                if (dp[i-coin]!=amount+1) {
                    dp[i] = min(dp[i], dp[i-coin]+1);
                }
            }
        }
        return dp[amount] == amount+1?-1:dp[amount];
    }
};
