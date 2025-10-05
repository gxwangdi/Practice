func titleToNumber(s string) int {
	length := len(s)
	if length < 1 {
		return 0
	}
	total := 0
	i := 0
	for i < length {
		total *= 26
		total += int(s[i]) - int('A') + 1
		i++
	}
	return total
}
