class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lpsArray = lps(s);
        int lastLPS = lpsArray[n - 1];
        int patternLength = n - lastLPS;
        return lastLPS > 0 && n % patternLength == 0;
    }

    private int[] lps(String str) {
        var chars = str.toCharArray();
        var lps = new int[str.length()];
        var len = 0; var i = 1;

        while(i < chars.length) {
            if(chars[len] == chars[i]) {
                lps[i] = ++len;
                i++;
            } else {
                if(len != 0)
                    len = lps[len-1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}