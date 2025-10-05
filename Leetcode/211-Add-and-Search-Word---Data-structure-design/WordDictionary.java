public class WordDictionary {

    private static class TrieNode {
        public boolean isLeaf;
        public TrieNode[] children;
        public TrieNode() {
            isLeaf = false;
            children = new TrieNode[26];
        }
    }
    
    private TrieNode root = new TrieNode();
    
    // s could be a pattern which includes '.', node can never be null.
    private boolean find(TrieNode node, String s, int cur) {
        if (cur >= s.length()) {
            return node.isLeaf;
        }
        char c = s.charAt(cur);
        if (c == '.') {
            for (TrieNode tn: node.children) {
                if (tn == null) {
                    continue;
                }
                if (find(tn, s, cur+1)) {
                    return true;
                }
            }
            return false;
        } else {
            int index = c- 'a';
            if (node.children[index] == null) {
                return false;
            }
            return find(node.children[index], s, cur+1);
        }
    }
    
    // node can never be null.
    private void insert(TrieNode node, String s) {
        int cur = 0;
        while (cur<s.length()) {
            int index = s.charAt(cur) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
            cur++;
        }
        node.isLeaf = true;
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        insert(root, word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        return find(root, word, 0);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");           




