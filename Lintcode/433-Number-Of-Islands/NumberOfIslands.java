import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	/**
	 * @param grid
	 *            a boolean 2D matrix
	 * @return an integer
	 */
	public int numIslands(boolean[][] grid) {
		int count = 0;
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return count;
		}
		int m = grid.length;
		int n = grid[0].length;
		Queue<Pair> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!grid[i][j]) {
					continue;
				}
				count++;
				q.offer(new Pair(i, j));
				merge(grid, m, n, q);
			}
		}
		return count;
	}// end of numIslands

	private void merge(boolean[][] grid, int m, int n, Queue<Pair> q) {
		while (!q.isEmpty()) {
			Pair p = q.poll();
			grid[p.x][p.y] = false;

			if (p.x > 0 && grid[p.x - 1][p.y]) {
				q.offer(new Pair(p.x - 1, p.y));
			}
			if (p.x < m - 1 && grid[p.x + 1][p.y]) {
				q.offer(new Pair(p.x + 1, p.y));
			}
			if (p.y > 0 && grid[p.x][p.y - 1]) {
				q.offer(new Pair(p.x, p.y - 1));
			}
			if (p.y < n - 1 && grid[p.x][p.y + 1]) {
				q.offer(new Pair(p.x, p.y + 1));
			}
		}
	}

	private static class Pair {
		public int x;
		public int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
