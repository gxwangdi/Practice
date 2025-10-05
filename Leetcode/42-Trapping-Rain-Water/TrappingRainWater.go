func trap(height []int) int {
	total := 0
	if height == nil || len(height) < 3 {
		return total
	}

	length := len(height)
	left := make([]int, length)
	right := make([]int, length)

	m := height[0]
	for i := 1; i < length; i++ {
		left[i] = max(m, height[i-1])
		m = max(m, height[i])
	}

	m = height[length-1]
	for i := length - 2; i >= 0; i-- {
		right[i] = max(m, height[i+1])
		m = max(m, height[i])
	}

	sum := 0
	for i := 1; i < length-1; i++ {
		sum = min(left[i], right[i]) - height[i]
		if sum > 0 {
			total += sum
		}
	}
	return total
}

func max(i, j int) int {
	if i > j {
		return i
	}
	return j
}

func min(i, j int) int {
	if i > j {
		return j
	}
	return i
}
