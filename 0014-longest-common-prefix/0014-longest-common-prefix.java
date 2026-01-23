class Solution {

    static class Trie {
        private static final int LIMIT = 26;
        private final Trie[] nodes;
        private int count;
        private int end;

        public Trie() {
            this.nodes = new Trie[LIMIT];
        }

        public void insert(String word) {
            var current = this;
            for (char ch : word.toCharArray()) {
                var key = ch - 'a';
                if (current.nodes[key] == null) {
                    current.nodes[key] = new Trie();
                }

                current = current.nodes[key];
                current.count++;
            }

            current.end++;
        }

        public boolean contains(String word) {
            var current = this;

            for (char ch : word.toCharArray()) {
                int key = ch - 'a';
                if (current.nodes[key] == null)
                    return false;
                current = current.nodes[key];
            }

            return current.end > 0;
        }

        public boolean startsWith(String word) {
            var current = this;

            for (char ch : word.toCharArray()) {
                int key = ch - 'a';

                if (current.nodes[key] == null)
                    return false;
                current = current.nodes[key];
            }

            return current.count > 0;
        }

        public String longestCommonPrefix() {
            var builder = new StringBuilder();
            var current = this;

            while (true) {
                var childCount = 0;
                var index = -1;
                for (int i = 0; i < LIMIT; i++) {
                    if (current.nodes[i] != null) {
                        childCount++;
                        index = i;
                    }
                }

                if (childCount != 1 || current.end > 0)
                    break;

                current = current.nodes[index];
                builder.append((char) (index + 'a'));
            }

            return builder.toString();
        }
    }

    public String longestCommonPrefix(String[] strs) {
        var trie = new Trie();
        for (var str : strs) {
            trie.insert(str);
        }

        return trie.longestCommonPrefix();
    }
}