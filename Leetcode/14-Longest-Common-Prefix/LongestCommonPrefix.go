func longestCommonPrefix(strs []string) string {
	if strs == nil || len(strs) == 0 {
		return ""
	}
	if len(strs) == 1 {
		return strs[0]
	}
	for i := 0; i < len(strs[0]); i++ {
		ch := strs[0][i]
		for _, str := range strs {
			if i < len(str) && ch == str[i] {
				continue
			}
			return str[0:i]
		}
	}
	return strs[0]
}
