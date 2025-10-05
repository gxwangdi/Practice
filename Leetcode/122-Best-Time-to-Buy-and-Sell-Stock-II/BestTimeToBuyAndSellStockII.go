func maxProfit(prices []int) int {
	profit := 0
	if prices == nil || len(prices) < 2 {
		return profit
	}
	cost := prices[0]
	cur := 1
	for cur < len(prices) {
		if prices[cur] < prices[cur-1] {
			profit = profit + prices[cur-1] - cost
			cost = prices[cur]
		}
		cur++
	}
	profit = profit + prices[cur-1] - cost
	return profit
}
