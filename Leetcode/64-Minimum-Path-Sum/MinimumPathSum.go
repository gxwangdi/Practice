func minPathSum(grid [][]int) int {
	lenX, lenY := len(grid[0]), len(grid)
	dp := make([][]int, lenY)
	for sum, y := 0, 0; y < lenY; y++ {
		dp[y] = make([]int, lenX)
		sum += grid[y][0]
		dp[y][0] = sum
	}
	for sum, x := 0, 0; x < lenX; x++ {
		sum += grid[0][x]
		dp[0][x] = sum
	}
	for y := 1; y < lenY; y++ {
		for x := 1; x < lenX; x++ {
			dp[y][x] = min(dp[y][x-1], dp[y-1][x]) + grid[y][x]
		}
	}
	return dp[lenY-1][lenX-1]
}

func min(i, j int) int {
	if i > j {
		return j
	}
	return i
}
