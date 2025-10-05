func trailingZeroes(n int) int {
	if n < 0 {
		return -1
	}

	ans := 0
	for n > 0 {
		n /= 5
		ans += n
	}
	return ans
}
