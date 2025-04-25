class Solution {
    static class Trie {
        private static final int LIMIT = 26;
        public final Trie[] nodes;
        private int end;
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
            }
            current.end++;
        }

        public String subString(String word) {
            var current = this;
            var builder = new StringBuilder();
            for(var ch: word.toCharArray()) {
                int idx = ch - 'a';
                if(current.nodes[idx] == null) {
                    return word;
                }
                current = current.nodes[idx];
                builder.append(ch);
                if(current.end > 0)
                    return builder.toString();
            }

            return builder.toString();
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for(String dic: dictionary) trie.insert(dic);
        var builder = new StringBuilder();
        var data = sentence.split(" ");
        for(var d: data) {
            builder.append(trie.subString(d)).append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}