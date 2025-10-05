func climbStairs(n int) int {
	if n <= 0 {
		return 0
	}
	if n < 3 {
		return n
	}
	dp := [2]int{1, 2}
	i := 2
	for i < n {
		dp[i%2] = dp[(i-1)%2] + dp[(i-2)%2]
		i++
	}
	return dp[(n-1)%2]
}
