func getRow(rowIndex int) []int {
	if rowIndex < 0 {
		return make([]int, 0)
	}
	if rowIndex == 0 {
		return []int{1}
	}
	cur := make([]int, 2)
	cur[0], cur[1] = 1, 1
	if rowIndex == 1 {
		return cur
	}
	for k := 2; k <= rowIndex; k++ {
		next := make([]int, k+1)
		next[0], next[k] = 1, 1
		for i := 1; i < k; i++ {
			next[i] = cur[i-1] + cur[i]
		}
		cur = next
	}
	return cur
}
