import java.util.StringTokenizer;
class Solution {
    public String reverseWords(String w) {
        w = w.trim();
        var tokens = new StringTokenizer(w);
        StringBuilder s = new StringBuilder();
        while (tokens.hasMoreTokens()) {
            s.insert(0, tokens.nextToken() + " ");
        }
        return s.toString().trim();
    }
}