import "sort"

func containsDuplicate(nums []int) bool {
	if nums == nil || len(nums) < 2 {
		return false
	}
	sort.Ints(nums)
	size := len(nums)
	for ind, val := range nums {
		if ind < size-1 && val == nums[ind+1] {
			return true
		}
	}
	return false
}
