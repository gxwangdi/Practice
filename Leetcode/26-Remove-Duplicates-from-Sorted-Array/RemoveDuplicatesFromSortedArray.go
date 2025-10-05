func removeDuplicates(nums []int) int {
	i := 0
	if nums == nil || len(nums) < 1 {
		return i
	}

	j := i + 1
	cur := nums[i]
	size := len(nums)
	for j < size {
		if nums[j] != cur {
			i++
			nums[i] = nums[j]
			cur = nums[i]
		}
		j++
	}
	return i + 1
}
