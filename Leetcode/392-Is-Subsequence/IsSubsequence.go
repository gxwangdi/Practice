func isSubsequence(s string, t string) bool {
	ls := len(s)
	lt := len(t)
	if ls > lt {
		return false
	}
	i := 0
	j := 0
	for i < ls && j < lt {
		if s[i] == t[j] {
			i++
		}
		j++
	}
	return i == ls
}
