
public class NumberOfBigIslands {
	/*
     * @param : a 2d boolean array
     * @param : an integer
     * @return: the number of Islands
     */
	public int numsofIsland(boolean[][] grid, int k) {
		int ret = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j]) {
					int size = dfs(grid, i, j);
					if (size >= k) {
						ret++;
					}
				}
			}
		}
		return ret;
	}

	private int dfs(boolean[][] grid, int m, int n) {
		if (m < 0 || m >= grid.length || n < 0 || n >= grid[0].length || !grid[m][n]) {
			return 0;
		}
		int count = 1;
		grid[m][n] = false;
		count += dfs(grid, m + 1, n);
		count += dfs(grid, m - 1, n);
		count += dfs(grid, m, n + 1);
		count += dfs(grid, m, n - 1);
		return count;
	}
}
