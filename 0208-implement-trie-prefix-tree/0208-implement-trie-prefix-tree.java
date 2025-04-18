class Trie {
    private static final int LIMIT = 26;
    private int count;
    private int end;
    private final Trie[] nodes;

    public Trie() {
        this.nodes = new Trie[LIMIT];
    }

    public void insert(String word) {
        var current = this;
        for(char ch: word.toCharArray()) {
            int idx = ch - 'a';
            if(current.nodes[idx] == null) {
                current.nodes[idx] = new Trie();
            }

            current = current.nodes[idx];
            current.count++;
        }
        current.end++;
    }

    public boolean search(String word) {
        var current = this;
        for(char ch: word.toCharArray()) {
            int idx = ch - 'a';
            if(current.nodes[idx] == null) {
                return false;
            }
            current = current.nodes[idx];
        }

        return current.end > 0;
    }

    public boolean startsWith(String prefix) {
        var current = this;
        for(char ch: prefix.toCharArray()) {
            int idx = ch - 'a';
            if(current.nodes[idx] == null) {
                return false;
            }
            current = current.nodes[idx];
        }

        return current.count > 0;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */