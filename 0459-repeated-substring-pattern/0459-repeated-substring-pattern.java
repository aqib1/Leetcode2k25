class Solution {
    public boolean repeatedSubstringPattern(String s) {
        var lps = lps(s);
        var n = s.length();
        var lastN = lps[lps.length - 1];
        var k = n - lastN;
        return lastN != 0 && n % k == 0;
    }

    public int[] lps(String value) {
        if(value == null || value.isEmpty())
            return null;
        var chars = value.toCharArray();
        var lps = new int[value.length()];
        var len = 0; var i = 1;
        while(i < chars.length) {
            if(chars[len] == chars[i]) {
                lps[i] = ++len;
                i++;
            } else {
                if(len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}