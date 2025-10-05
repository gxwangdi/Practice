func canConstruct(ransomNote string, magazine string) bool {
	if len(ransomNote) > len(magazine) {
		return false
	}
	var count [26]int
	for _, val := range magazine {
		index := int(val) - int('a')
		count[index]++
	}
	for _, val := range ransomNote {
		index := int(val) - int('a')
		count[index]--
		if count[index] < 0 {
			return false
		}
	}
	return true
}
