func moveZeroes(nums []int) {
	if nums == nil || len(nums) < 2 {
		return
	}
	slow := 0
	fast := 0
	size := len(nums)
	for fast < size {
		if nums[fast] == 0 {
			fast += 1
			continue
		}
		nums[slow] = nums[fast]
		slow += 1
		fast += 1
	}
	for slow < size {
		nums[slow] = 0
		slow += 1
	}
}
