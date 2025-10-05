func findKthLargest(nums []int, k int) int {
	if nums == nil || len(nums) == 0 || k <= 0 {
		return 0
	}
	size := len(nums)
	return helper(nums, 0, size-1, size-k+1)
}

func helper(nums []int, left, right, k int) int {
	if left == right {
		return nums[left]
	}
	pos := partition(nums, left, right)
	if pos+1 == k {
		return nums[pos]
	} else if pos+1 < k {
		return helper(nums, pos+1, right, k)
	} else {
		return helper(nums, left, pos-1, k)
	}
}

func partition(nums []int, left, right int) int {
	pivot := nums[left]
	for left < right {
		for left < right && nums[right] >= pivot {
			right -= 1
		}
		nums[left] = nums[right]
		for left < right && nums[left] < pivot {
			left += 1
		}
		nums[right] = nums[left]
	}
	nums[left] = pivot
	return left
}
