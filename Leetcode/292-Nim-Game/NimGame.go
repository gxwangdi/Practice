func canWinNim(n int) bool {
	if n < 0 {
		return false
	}
	return n%4 != 0
}
