import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	/**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
	public void surroundedRegions(char[][] board) {
		if (board == null || board.length == 0) {
			return;
		}
		int m = board.length;
		int n = board[0].length;
		Queue<Coordinate> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			if (board[i][0] == O) {
				q.offer(new Coordinate(i, 0));
			}
			if (board[i][n - 1] == O) {
				q.offer(new Coordinate(i, n - 1));
			}
		}
		for (int j = 1; j < n - 1; j++) {
			if (board[0][j] == O) {
				q.offer(new Coordinate(0, j));
			}
			if (board[m - 1][j] == O) {
				q.offer(new Coordinate(m - 1, j));
			}
		}
		Queue<Coordinate> yq = new LinkedList<>();
		while (!q.isEmpty()) {
			Coordinate c = q.poll();
			board[c.x][c.y] = Y;
			yq.offer(c);
			if (c.x > 0 && board[c.x - 1][c.y] == O) {
				q.offer(new Coordinate(c.x - 1, c.y));
			}
			if (c.x < m - 1 && board[c.x + 1][c.y] == O) {
				q.offer(new Coordinate(c.x + 1, c.y));
			}
			if (c.y > 0 && board[c.x][c.y - 1] == O) {
				q.offer(new Coordinate(c.x, c.y - 1));
			}
			if (c.y < n - 1 && board[c.x][c.y + 1] == O) {
				q.offer(new Coordinate(c.x, c.y + 1));
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == O) {
					board[i][j] = X;
				}
			}
		}

		while (!yq.isEmpty()) {
			Coordinate c = yq.poll();
			board[c.x][c.y] = O;
		}
	}

	private static class Coordinate {
		public int x;
		public int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private final char Y = 'Y';
	private final char O = 'O';
	private final char X = 'X';
}
