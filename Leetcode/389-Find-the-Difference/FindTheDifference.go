func findTheDifference(s string, t string) byte {
	cur := t[0]
	for i := 1; i < len(t); i++ {
		cur = cur ^ t[i]
	}
	for i := 0; i < len(s); i++ {
		cur = cur ^ s[i]
	}
	return cur
}
