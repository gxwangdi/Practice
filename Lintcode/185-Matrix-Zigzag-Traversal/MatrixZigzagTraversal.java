public class MatrixZigzagTraversal {
	/**
	 * @param matrix
	 *            : a matrix of integers
	 * @return: an array of integers
	 */
	public int[] printZMatrix(int[][] matrix) {
		int x;
		int y;
		int dx;
		int dy;
		int count;
		int m;
		int n;
		x = y = 0;
		count = 1;
		dx = -1;
		dy = 1;
		m = matrix.length;
		n = matrix[0].length;
		int[] z = new int[m * n];
		z[0] = matrix[0][0];

		while (count < m * n) {
			if (x + dx >= 0 && y + dy >= 0 && x + dx < m && y + dy < n) {
				// If not reaching matrix boundary.
				x += dx;
				y += dy;
			} else {
				if (dx == -1 && dy == 1) {
					if (y + 1 < n) {
						y++;
					} else {
						x++;
					}
					dx = 1;
					dy = -1;
				} else {
					if (x + 1 < m) {
						x++;
					} else {
						y++;
					}
					dx = -1;
					dy = 1;
				}
			}
			z[count] = matrix[x][y];
			count++;
		}
		return z;
	}
}
