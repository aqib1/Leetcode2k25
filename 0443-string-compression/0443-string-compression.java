class Solution {

    // Time complexity O(n)
    // Space complexity O(1)
    public int compress(char[] data) {
       var ptr = 0;
        var count = 0;

        for(int i = 0; i < data.length;) {
            var current = data[i];
            data[ptr++] = current;
            while(i < data.length && current == data[i]) {
                count++;
                i++;
            }

            if(count > 1) {
                for(char ch: String.valueOf(count).toCharArray()) {
                    data[ptr++] = ch;
                }
            }
            count = 0;
        }

        return ptr;
    }
}