func plusOne(digits []int) []int {
	if digits == nil || len(digits) == 0 {
		return digits
	}
	if digits[len(digits)-1] < 9 {
		digits[len(digits)-1]++
		return digits
	}
	i := len(digits) - 1
	for i >= 0 {
		if digits[i] == 9 {
			digits[i] = 0
			i--
		} else {
			digits[i]++
			break
		}
	}
	if i == -1 {
		digits = append([]int{1}, digits...)
	}
	return digits
}
