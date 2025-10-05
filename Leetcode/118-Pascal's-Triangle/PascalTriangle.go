func generate(numRows int) [][]int {
	if numRows < 1 {
		return make([][]int, 0)
	}
	res := make([][]int, numRows)
	for row := 0; row < numRows; row++ {
		list := make([]int, row+1)
		list[0], list[row] = 1, 1
		for j := 1; j < row; j++ {
			list[j] = res[row-1][j] + res[row-1][j-1]
		}
		res[row] = list
	}
	return res
}
