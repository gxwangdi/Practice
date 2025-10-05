func coinChange(coins []int, amount int) int {
	if amount < 1 {
		return 0
	}
	var a = amount + 1
	// var dp [a]int
	dp := make([]int, a)
	for i := 0; i < a; i++ {
		dp[i] = a
	}
	dp[0] = 0
	for _, coin := range coins {
		for i := coin; i < a; i++ {
			if dp[i-coin] != a {
				dp[i] = min(dp[i], dp[i-coin]+1)
			}
		}
	}
	if dp[amount] == a {
		return -1
	}
	return dp[amount]
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}
