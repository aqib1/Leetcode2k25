class Solution {
public:
    // Time complexity O(n)
    // Space complexity O(1)
    void reverseString(vector<char>& s) {
        int start = 0;
        int end = s.size() - 1;

        while(start < end) {
          char tmp = s[start];
          s[start++] = s[end];
          s[end--] = tmp;
        }
    }
};