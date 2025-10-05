func max(i1, i2 int) int {
	if i1 >= i2 {
		return i1
	}
	return i2
}

func lengthOfLongestSubstring(s string) int {
	res := 0
	if len(s) == 0 {
		return res
	}
	flag := make([]bool, 256)
	start := 0
	length := len(s)
	i := 0
	for i < length {
		cur := s[i]
		curIdx := int(cur)
		if !flag[curIdx] {
			flag[curIdx] = true
			continue
		}
		res = max(res, i-start)
		j := start
		for j < i {
			curj := s[j]
			curIdxj := int(curj)
			if cur == curj {
				start = j + 1
				break
			}
			flag[curIdxj] = false
			j++
		}
		i++
	}
	res = max(res, length-start)
	return res
}
