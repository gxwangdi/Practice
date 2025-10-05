func findMin(nums []int) int {
	res := nums[0]
	for _, val := range nums {
		res = min(res, val)
	}
	return res
}

func min(i, j int) int {
	if i < j {
		return i
	}
	return j
}
