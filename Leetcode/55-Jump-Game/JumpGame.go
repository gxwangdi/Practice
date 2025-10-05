func canJump(nums []int) bool {
	if nums == nil || len(nums) == 0 {
		return false
	}
	size := len(nums)
	dp := make([]bool, size)
	dp[0] = true
	cur := 0
	for ind, val := range nums {
		if !dp[ind] {
			return false
		}
		far := ind + val
		if far >= size-1 {
			return true
		}
		if far < cur {
			continue
		}
		for cur <= far {
			dp[cur] = true
			cur++
		}
	}
	return dp[size-1]
}
