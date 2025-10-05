func searchRange(nums []int, target int) []int {
	res := []int{-1, -1}
	if nums == nil || len(nums) == 0 {
		return res
	}
	res[0] = binarySearch(nums, target, true)
	if res[0] == -1 {
		return res
	}
	res[1] = binarySearch(nums, target, false)
	return res
}

func binarySearch(nums []int, target int, isLower bool) int {
	left := 0
	right := len(nums) - 1
	var mid int
	for left+1 < right {
		mid = left + (right-left)/2
		if nums[mid] == target {
			if isLower {
				right = mid
			} else {
				left = mid
			}
			continue
		}
		if nums[mid] < target {
			left = mid
			continue
		}
		if nums[mid] > target {
			right = mid
		}
	}
	res := -1
	if isLower {
		if nums[left] == target {
			res = left
		} else if nums[right] == target {
			res = right
		}
	} else {
		if nums[right] == target {
			res = right
		} else if nums[left] == target {
			res = left
		}
	}
	return res
}
