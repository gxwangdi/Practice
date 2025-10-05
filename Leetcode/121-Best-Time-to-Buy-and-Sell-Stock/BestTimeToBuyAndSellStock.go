func maxProfit(prices []int) int {
	if prices == nil || len(prices) < 2 {
		return 0
	}
	profit := 0
	cost := prices[0]
	for _, value := range prices {
		profit = max(profit, value-cost)
		cost = min(cost, value)
	}
	return profit
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
