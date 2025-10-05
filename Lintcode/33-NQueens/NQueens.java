import java.util.ArrayList;
import java.util.Arrays;


public class NQueens {
	/**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
	public ArrayList<ArrayList<String>> solveNQueens(int n) {
		ArrayList<ArrayList<String>> res = new ArrayList<>();
		if (n < 1) {
			return res;
		}
		boolean[] ocp90 = new boolean[n];
		boolean[] ocp45 = new boolean[2 * n - 1];
		boolean[] ocp135 = new boolean[2 * n - 1];

		char[][] board = new char[n][n];
		for (char[] arr : board) {
			Arrays.fill(arr, '.');
		}

		solve(0, n, board, res, ocp45, ocp90, ocp135);
		return res;
	}// end of solveNQueens.

	private void solve(int depth, int n, char[][] board,
			ArrayList<ArrayList<String>> res, boolean[] ocp45, boolean[] ocp90,
			boolean[] ocp135) {
		if (depth == n) {
			addSolution(res, board);
			return;
		}

		for (int j = 0; j < n; j++) {
			if (!ocp90[j] && !ocp45[depth + j] && !ocp135[j - depth + n - 1]) {
				ocp90[j] = true;
				ocp45[depth + j] = true;
				ocp135[j - depth + n - 1] = true;
				board[depth][j] = 'Q';
				solve(depth + 1, n, board, res, ocp45, ocp90, ocp135);
				ocp90[j] = false;
				ocp45[depth + j] = false;
				ocp135[j - depth + n - 1] = false;
				board[depth][j] = '.';
			}
		}
	}// end of solve

	private void addSolution(ArrayList<ArrayList<String>> res, char[][] board) {
		ArrayList<String> cur = new ArrayList<>();
		for (char[] i : board) {
			cur.add(new String(i));
		}
		res.add(cur);
	}
}
