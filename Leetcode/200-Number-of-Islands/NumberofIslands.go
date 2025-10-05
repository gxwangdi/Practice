func numIslands(grid [][]byte) int {
	if grid == nil || len(grid) < 1 || len(grid[0]) < 1 {
		return 0
	}
	m := len(grid)
	n := len(grid[0])

	count := 0
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == '1' {
				count++
				merge(grid, i, j)
			}
		}
	}
	return count
}

func merge(grid [][]byte, i, j int) {
	m := len(grid)
	n := len(grid[0])

	if i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1' {
		return
	}
	grid[i][j] = 'X'

	merge(grid, i-1, j)
	merge(grid, i+1, j)
	merge(grid, i, j-1)
	merge(grid, i, j+1)
}
