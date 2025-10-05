func productExceptSelf(nums []int) []int {
	res := make([]int, len(nums))
	p := 1
	res[0] = 1
	for i := 1; i < len(nums); i++ {
		p *= nums[i-1]
		res[i] = p
	}
	p = 1
	for i := len(nums) - 2; i >= 0; i-- {
		p *= nums[i+1]
		res[i] *= p
	}
	return res
}
