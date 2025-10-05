func twoSum(numbers []int, target int) []int {
	if numbers == nil || len(numbers) < 2 {
		return []int{-1, -1}
	}
	left := 0
	length := len(numbers)
	right := length - 1
	for left < right {
		sum := numbers[left] + numbers[right]
		if sum == target {
			return []int{left + 1, right + 1}
		} else if sum > target {
			right--
		} else {
			left++
		}
	}
	return []int{-1, -1}
}
