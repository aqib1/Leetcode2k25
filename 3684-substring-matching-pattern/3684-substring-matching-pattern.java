class Solution {
    public boolean hasMatch(String s, String p) {
        var ps = p.split("\\*");
        var psIndex = 0;
        var start = 0;

        while (start < s.length() && psIndex < ps.length) {
            var i = s.indexOf(ps[psIndex], start);
            if (i == -1) return false;
            start = i + ps[psIndex++].length();
        }

        return psIndex == ps.length;
    }
}