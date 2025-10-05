#include <algorithm>

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.size()<2) {
            return 0;
        }

        int profit = 0;
        int min = prices.at(0);
        for (int i=0; i<prices.size(); i++) {
            profit = std::max(profit, prices[i]-min);
            min = std::min(min, prices[i]);
        }
        return profit;
    }
};
