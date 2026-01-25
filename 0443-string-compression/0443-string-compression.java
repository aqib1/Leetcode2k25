class Solution {

    // Time complexity O(n)
    // Space complexity O(1)
    public int compress(char[] chars) {
        int count = 0;
        int ptr = 0;
        for (int i = 0; i < chars.length;) {
            var curr = chars[i];
            chars[ptr++] = curr;
            while (i < chars.length && chars[i] == curr) {
                count++;
                i++;
            }
            if (count > 1) {
                for (char ch : String.valueOf(count).toCharArray()) {
                    chars[ptr++] = ch;
                }
            }
            count = 0;
        }
        return ptr;
    }
}