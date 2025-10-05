func validPalindrome(s string) bool {
	return valid(s, 0, len(s)-1, 0)
}

func valid(s string, left int, right int, times int) bool {
	for left < right {
		if s[left] != s[right] {
			if times < 1 {
				return valid(s, left+1, right, times+1) || valid(s, left, right-1, times+1)
			} else {
				return false
			}
		}
		left++
		right--
	}
	return true
}
