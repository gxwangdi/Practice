/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    if (!prices || prices.length < 2) {
        return 0;
    }
    var profit = 0
    var cost = prices[0]
    for (index in prices) {
        profit = Math.max(profit, prices[index]-cost)
        cost = Math.min(cost, prices[index])
    }
    return profit
};
