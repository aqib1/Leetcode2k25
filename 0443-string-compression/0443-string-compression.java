class Solution {

    // Time complexity O(n)
    // Space complexity O(1)
    public int compress(char[] data) {
        int ptr = 0;
        int count = 0;

        for (int i = 0; i < data.length;) {
            var ch = data[i];
            data[ptr++] = ch;
            while (i < data.length && ch == data[i]) {
                count++;
                i++;
            }
            if (count > 1) {
                for (var n : String.valueOf(count).toCharArray()) {
                    data[ptr++] = n;
                }
            }
            count = 0;
        }
        return ptr;
    }
}