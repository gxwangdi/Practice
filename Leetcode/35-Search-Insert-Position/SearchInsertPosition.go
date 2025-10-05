func searchInsert(nums []int, target int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	}
	start := 0
	end := len(nums) - 1
	for start < end {
		mid := start + (end-start)/2
		if nums[mid] == target {
			return mid
		}
		if nums[mid] > target {
			end = mid - 1
		} else {
			start = mid + 1
		}
	}
	//     start == end
	if nums[start] < target {
		return start + 1
	}
	return start
}
