import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWaterII {
	/*
	 * @param heights: a matrix of integers
	 * 
	 * @return: an integer
	 */
	public int trapRainWater(int[][] heights) {
		if (heights == null || heights.length == 0 || heights[0].length == 0) {
			return 0;
		}
		int m = heights.length;
		int n = heights[0].length;

		PriorityQueue<Cell> minheap = new PriorityQueue<Cell>(1, new Comparator<Cell>() {
			public int compare(Cell c1, Cell c2) {
				if (c1.h > c2.h) {
					return 1;
				} else if (c1.h < c2.h) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		int[][] visited = new int[m][n];
		// Traverse the outer cells, add to the minheap
		for (int i = 0; i < m; i++) {
			minheap.offer(new Cell(i, 0, heights[i][0]));
			minheap.offer(new Cell(i, n - 1, heights[i][n - 1]));

			visited[i][0] = 1;
			visited[i][n - 1] = 1;
		}

		for (int j = 0; j < n; j++) {
			minheap.offer(new Cell(0, j, heights[0][j]));
			minheap.offer(new Cell(m - 1, j, heights[m - 1][j]));

			visited[0][j] = 1;
			visited[m - 1][j] = 1;
		}
		// Helper direction array
		int[] dirX = new int[] { 0, 0, -1, 1 };
		int[] dirY = new int[] { -1, 1, 0, 0 };

		int water = 0;

		// Starting from the min height cell, check 4 direction
		while (!minheap.isEmpty()) {
			Cell now = minheap.poll();

			for (int k = 0; k < 4; k++) {
				int x = now.x + dirX[k];
				int y = now.y + dirY[k];

				if (x < m && x >= 0 && y < n && y >= 0 && visited[x][y] != 1) {
					minheap.offer(new Cell(x, y, Math.max(now.h, heights[x][y])));
					visited[x][y] = 1;

					// Fill in water or not
					water += Math.max(0, now.h - heights[x][y]);
				}
			}
		}
		return water;
	}

	private static class Cell {
		public int x, y, h;

		public Cell() {
		}

		public Cell(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}
}
