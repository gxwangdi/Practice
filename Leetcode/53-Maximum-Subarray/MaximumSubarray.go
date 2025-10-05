import "math"

func maxSubArray(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	}

	max := math.MinInt64
	sum := 0
	for _, val := range nums {
		sum += val
		max = int(math.Max(float64(max), float64(sum)))
		sum = int(math.Max(float64(sum), 0.0))
	}
	return max
}
