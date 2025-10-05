func removeElement(nums []int, val int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	}
	i := 0
	j := 0
	length := len(nums)
	for j < length {
		if nums[j] != val {
			nums[i] = nums[j]
			i++
		}
		j++
	}
	return i
}
