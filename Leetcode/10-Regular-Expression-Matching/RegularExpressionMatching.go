func isMatch(s string, p string) bool {
	if len(p) == 0 {
		return len(s) == 0
	}

	if len(p) == 1 || p[1] != '*' {
		if len(s) == 0 || (p[0] != '.' && p[0] != s[0]) {
			return false
		} else {
			return isMatch(s[1:], p[1:])
		}
	}

	for len(s) > 0 && (s[0] == p[0] || p[0] == '.') {
		if isMatch(s, p[2:]) {
			return true
		}
		s = s[1:]
	}

	return isMatch(s, p[2:])
}
