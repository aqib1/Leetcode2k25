class Solution {
    public char findTheDifference(String s, String t) {
        var s1 = 0; var t1 = 0;

        for(char c: s.toCharArray()) {
            s1 += c;
        }

        for(char c: t.toCharArray()) {
            t1 += c;
        }

        return (char)(t1 - s1);
    }
}