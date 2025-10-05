func integerReplacement(n int) int {
	count := 0
	for n != 1 {
		small := n & (n - 1)
		big := n & (n + 1)
		if (n & 1) == 0 {
			n >>= 1
		} else if (small & (small - 1)) <= (big & (big - 1)) {
			n -= 1
		} else {
			n += 1
		}
		count += 1
	}
	return count
}
