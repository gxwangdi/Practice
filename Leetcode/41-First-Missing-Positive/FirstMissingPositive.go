func firstMissingPositive(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return 1
	}
	size := len(nums)
	for i := 0; i < size; i++ {
		if nums[i] <= 0 {
			continue
		}
		if nums[i] > size {
			continue
		}
		if nums[nums[i]-1] == nums[i] {
			continue
		}
		temp := nums[i]
		nums[i], nums[temp-1] = nums[temp-1], nums[i]
		i--
	}

	for ind, val := range nums {
		if val != ind+1 {
			return ind + 1
		}
	}
	return size + 1
}
