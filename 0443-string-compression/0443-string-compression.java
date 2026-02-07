class Solution {

    // Time complexity O(n)
    // Space complexity O(1)
    public int compress(char[] data) {
        int ptr = 0;
        int count = 0;

        for(int i = 0; i < data.length;) {
            var cr = data[i];
            data[ptr++] = cr;

            while(i < data.length && cr == data[i]) {
                count++;
                i++;
            }

            if(count > 1) {
                for(var ch: String.valueOf(count).toCharArray()) {
                    data[ptr++] = ch;
                }
            }

            count = 0;
        }

        return ptr;
    }
}