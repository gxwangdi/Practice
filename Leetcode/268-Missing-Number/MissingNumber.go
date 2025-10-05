func missingNumber(nums []int) int {
	if len(nums) == 0 {
		return -1
	}
	res := 0
	for ind, val := range nums {
		res = res ^ val ^ (ind + 1)
	}
	return res
}
