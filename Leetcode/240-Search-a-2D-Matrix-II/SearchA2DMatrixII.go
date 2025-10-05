func searchMatrix(matrix [][]int, target int) bool {
	if matrix == nil || len(matrix) == 0 || len(matrix[0]) == 0 {
		return false
	}
	i := 0
	j := len(matrix[0]) - 1
	length := len(matrix)
	for i < length && j >= 0 {
		temp := matrix[i][j]
		if temp == target {
			return true
		}
		if temp > target {
			j--
		} else {
			i++
		}
	}
	return false
}
