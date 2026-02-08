class Solution {
    // Time complexity O(n)
    // Space complexity O(1)
    public int compress(char[] data) {
        var ptr = 0;
        var count = 0;
        
        for(int i = 0; i < data.length; ) {
            var curr = data[i];
            data[ptr++] = curr;

            while(i < data.length && data[i] == curr) {
                count++;
                i++;
            }

            if(count > 1) {
                for(var c: String.valueOf(count).toCharArray()) {
                    data[ptr++] = c;
                }
            }

            count = 0;
        }

        return ptr;
    }
}