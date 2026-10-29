class Solution {
    public int lengthOfLongestSubstring(String str) {
        var count = new char[256];
        var charArr = str.toCharArray();
        int maxLen = 0;
        int i = 0, j = 0;
        while(j < charArr.length) {
            if(count[charArr[j]] < 1) {
                count[charArr[j++]]++;
                maxLen = Math.max(maxLen, j - i);
            } else {
                count[charArr[i++]]--;
            }
        }

        return maxLen;
    }
}