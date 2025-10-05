func bulbSwitch(n int) int {
	if n < 1 {
		return 0
	}
	res := 1
	for res*res <= n {
		res += 1
	}
	return res - 1
}
