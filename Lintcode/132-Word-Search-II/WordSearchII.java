import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
	/**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
	public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
		ArrayList<String> res = new ArrayList<>();
		TrieNode root = buildTrie(words);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(res, board, i, j, root);
			}
		}
		return res;
	}

	private void dfs(List<String> res, char[][] board, int i, int j, TrieNode p) {
		char c = board[i][j];
		if (c == '#' || p.next[c - 'a'] == null) {
			return;
		}
		p = p.next[c - 'a'];
		if (p.word != null) {
			res.add(p.word);
			p.word = null; // avoid duplicate visit
		}
		board[i][j] = '#';
		if (i > 0) {
			dfs(res, board, i - 1, j, p);
		}
		if (j > 0) {
			dfs(res, board, i, j - 1, p);
		}
		if (i < board.length - 1) {
			dfs(res, board, i + 1, j, p);
		}
		if (j < board[0].length - 1) {
			dfs(res, board, i, j + 1, p);
		}
		board[i][j] = c;
	}

	private TrieNode buildTrie(ArrayList<String> words) {
		TrieNode root = new TrieNode();
		for (String s : words) {
			TrieNode p = root;
			char[] arr = s.toCharArray();
			for (char c : arr) {
				int index = c - 'a';
				if (p.next[index] == null) {
					p.next[index] = new TrieNode();
				}
				p = p.next[index];
			}
			p.word = s;
		}
		return root;
	}

	private static class TrieNode {
		TrieNode[] next = new TrieNode[26];
		String word; // null for leaf node.
	}
}
