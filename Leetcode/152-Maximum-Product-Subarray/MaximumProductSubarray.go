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

func maxProduct(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	}

	maxProduct := nums[0]
	maxTemp := 1
	minTemp := 1

	for _, val := range nums {
		a := maxTemp * val
		b := minTemp * val
		maxTemp = max(max(a, b), val)
		minTemp = min(min(a, b), val)
		maxProduct = max(maxProduct, maxTemp)
	}
	return maxProduct
}
