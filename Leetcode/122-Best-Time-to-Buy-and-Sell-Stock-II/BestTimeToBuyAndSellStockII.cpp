class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int profit = 0;
        if (prices.empty()) {
            return profit;
        }
        int cost = prices[0];
        int cur = 1;
        while (cur<prices.size()) {
            if (prices[cur] <prices[cur-1]) {
                profit = profit + prices[cur-1] - cost;
                cost = prices[cur];
            }
            cur++;
        }
        profit = profit + prices[cur-1] - cost;
        return profit;
    }
};
