class Trie {
    private static final int LIMIT = 26;
    private int end;
    private int count;
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


    public int countWordsEqualTo(String word) {
        var current = this;
        for(char ch: word.toCharArray()) {
            int idx = ch - 'a';
            if(current.nodes[idx] == null)
                return 0;
            current =  current.nodes[idx];
        }

        return current.end;
    }

    public int countWordsStartingWith(String prefix) {
        var current = this;
        for(char ch: prefix.toCharArray()) {
            int idx = ch - 'a';
            if(current.nodes[idx] == null)
                return 0;
            current =  current.nodes[idx];
        }

        return current.count;
    }

    public void erase(String word) {
        var current = this;
        for(char ch: word.toCharArray()) {
            int idx = ch - 'a';
            if(current.nodes[idx] != null)
                current = current.nodes[idx];
            current.count--;
        }
        current.end--;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */