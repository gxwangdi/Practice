import "math"

func jump(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return -1
	}
	size := len(nums)
	if size == 1 {
		return 0
	}
	dp := make([]int, size)
	for i := range dp {
		dp[i] = math.MaxInt64
	}
	dp[0] = 0
	cur := 1
	for ind, val := range nums {
		far := ind + val
		value := dp[ind] + 1
		if far >= size-1 {
			return value
		}
		if far < cur {
			continue
		}
		for cur <= far {
			dp[cur] = value
			cur++
		}
	}
	return dp[size-1]
}
