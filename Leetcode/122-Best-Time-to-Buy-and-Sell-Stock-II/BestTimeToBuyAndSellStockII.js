/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    var profit = 0
    if (!prices || prices.length<2) {
        return profit
    }
    var cost = prices[0]
    var cur = 1
    while (cur<prices.length) {
        if (prices[cur] < prices[cur-1]) {
            profit = profit + prices[cur-1] - cost
            cost = prices[cur]
        }
        cur++
    }
    profit = profit + prices[cur-1] - cost
    return profit
};
