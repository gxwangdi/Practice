func lengthOfLastWord(s string) int {
	res := 0
	an := 0
	for i := 0; i < len(s); i++ {
		if s[i] == ' ' {
			if res != 0 {
				an = res
			}
			res = 0
		} else {
			res++
		}
	}
	if res != 0 {
		return res
	}
	return an
}
