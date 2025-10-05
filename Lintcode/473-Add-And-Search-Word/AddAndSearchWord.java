
public class AddAndSearchWord {

	private TrieNode root = new TrieNode();

	// Adds a word into the data structure.
	public void addWord(String word) {
		if (word == null || word.length() < 1) {
			return;
		}
		if (root == null) {
			root = new TrieNode();
		}
		TrieNode itr = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = c - 'a';
			if (itr.children[index] == null) {
				itr.children[index] = new TrieNode();
			}
			itr = itr.children[index];
		}
		itr.word = word;
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		if (root == null || word == null || word.length() < 1) {
			return false;
		}
		return search(word, 0, root);
	}

	private boolean search(final String word, final int index,
			final TrieNode cur) {
		if (index >= word.length()) {
			return cur.word != null;
		}
		char c = word.charAt(index);
		if (c == '.') {
			for (TrieNode n : cur.children) {
				if (n != null && search(word, index + 1, n)) {
					return true;
				}
			}
			return false;
		} else {
			int pos = c - 'a';
			if (cur.children[pos] == null) {
				return false;
			} else {
				return search(word, index + 1, cur.children[pos]);
			}
		}
	}

	private static class TrieNode {
		String word = null;
		TrieNode[] children = new TrieNode[26];
	}
}

//Your WordDictionary object will be instantiated and called as such:
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("word");
//wordDictionary.search("pattern");

