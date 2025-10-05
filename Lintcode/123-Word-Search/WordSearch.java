
public class WordSearch {
	/**
	 * @param board: A list of lists of character
	 * @param word: A string
	 * @return: A boolean
	 */
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || word == null) {
			return false;
		}
		if (word.length() == 0) {
			return true;
		}
		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dfs(board, i, j, word, 0, visited)) {
					return true;
				}
			}
		}
		return false;
	}// end of exist

	private boolean dfs(char[][] board, int x, int y, String word, int cur, boolean[][] visited) {

		if (board[x][y] != word.charAt(cur)) {
			return false;
		}
		cur++;
		if (cur >= word.length()) {
			return true;
		}
		visited[x][y] = true;
		if (x > 0 && !visited[x - 1][y] && dfs(board, x - 1, y, word, cur, visited)) {
			return true;
		}
		if (y > 0 && !visited[x][y - 1] && dfs(board, x, y - 1, word, cur, visited)) {
			return true;
		}
		if (x + 1 < board.length && !visited[x + 1][y] && dfs(board, x + 1, y, word, cur, visited)) {
			return true;
		}
		if (y + 1 < board[0].length && !visited[x][y + 1] && dfs(board, x, y + 1, word, cur, visited)) {
			return true;
		}
		visited[x][y] = false;
		return false;
	}
}
