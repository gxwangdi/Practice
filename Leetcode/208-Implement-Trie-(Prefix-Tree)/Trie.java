class TrieNode {
    
    TrieNode[] children;
    boolean isLeaf;
    // Initialize your data structure here.
    public TrieNode() {
        children = new TrieNode[26];
        isLeaf = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        int cur = 0;
        TrieNode node = root;
        while (cur < word.length()) {
            char c = word.charAt(cur++);
            if (node.children[c-'a'] == null) {
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isLeaf = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root; 
        int cur = 0;
        while (node!=null && cur<word.length()) {
            char c = word.charAt(cur++);
            node = node.children[c-'a'];
        }
        if (cur < word.length()) {
            return false;
        }
        return node!= null && node.isLeaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        int cur = 0;
        while (node!=null && cur<prefix.length()) {
            char c = prefix.charAt(cur++);
            node = node.children[c-'a'];
        }
        if (cur < prefix.length()) {
            return false;
        }
        return node!=null;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");





