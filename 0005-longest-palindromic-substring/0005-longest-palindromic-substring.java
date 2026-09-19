class Solution {
    public String longestPalindrome(String s) {
        int limit = s.length();
        for (int j = limit; j > 0; j--) {
            for (int i = 0; i <= limit - j; i++) {
                if (check(i, (i + j) - 1, s)) {
                    return s.substring(i, i + j);
                }
            }
        }
        return "";
    }

    private boolean check(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }
}