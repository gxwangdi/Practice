func singleNumber(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	}
	res := 0
	for _, value := range nums {
		res ^= value
	}
	return res
}
