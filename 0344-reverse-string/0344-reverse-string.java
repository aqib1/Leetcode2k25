class Solution {
    // time O(n) + space O(1)
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while(start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}