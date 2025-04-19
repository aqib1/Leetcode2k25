class MapSum {
    static class Trie {
        private static final int LIMIT = 26;
        private final Trie[] nodes;
        private final Map<String, Integer> keyMap;
        private int sum;

        public Trie() {
            this.nodes = new Trie[LIMIT];
            this.keyMap = new HashMap<>();
        }

        // Time complexity O(N) & Space O(S * N) where S is alphabet size
        public void insert(String key, int val) {
            var count = val - keyMap.getOrDefault(key, 0);
            keyMap.put(key, val);
            var current = this;
            for (var ch : key.toCharArray()) {
                int idx = ch - 'a';
                if (current.nodes[idx] == null)
                    current.nodes[idx] = new Trie();

                current = current.nodes[idx];
                current.sum += count;
            }
        }

        // Time complexity O(N) & Space O(S * N) where S is alphabet size
        public int sum(String prefix) {
            var current = this;
            for (var ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (current.nodes[idx] == null)
                    return 0;

                current = current.nodes[idx];
            }

            return current.sum;
        }
    }

    private final Trie root;
    public MapSum() {
        this.root = new Trie();
    }

    public void insert(String key, int val) {
        root.insert(key, val);
    }

    public int sum(String prefix) {
        return root.sum(prefix);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */