
/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    // Initialize your data structure here.
    public String word;
    public TrieNode[] children;
    
    public TrieNode() {
        children = new TrieNode[26];
        word = null;
    }
}

public class ImplementTrie {
	private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null) {
            return;
        }
        word = word.toLowerCase();
        int index = 0;
        TrieNode cur = root;
        while (index < word.length()) {
            char c = word.charAt(index);
            if (cur.children[c-'a'] == null) {
                cur.children[c-'a'] = new TrieNode();
            }
            cur = cur.children[c-'a'];
            index++;
        }
        cur.word = word;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        word = word.toLowerCase();
        int index = 0;
        TrieNode cur = root;
        while (index < word.length()) {
            char c = word.charAt(index);
            if (cur.children[c-'a'] == null) {
                return false;
            }
            cur = cur.children[c-'a'];
            index++;
        }
        return cur.word != null;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }
        prefix = prefix.toLowerCase();
        int index = 0;
        TrieNode cur = root;
        while (index < prefix.length()) {
            char c = prefix.charAt(index);
            if (cur.children[c-'a'] == null) {
                return false;
            }
            cur = cur.children[c-'a'];
            index++;
        }
        return true;
    }
}
