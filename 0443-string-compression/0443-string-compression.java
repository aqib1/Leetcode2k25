class Solution {

    // Time complexity O(n)
    // Space complexity O(1)
    public int compress(char[] chars) {
       int ptr = 0;
       int count = 0;

       for(int i = 0; i < chars.length;) {
           var current = chars[i];
           chars[ptr++] = current;

           while(i < chars.length && chars[i] == current) {
               count++;
               i++;
           }

           if(count > 1) {
               for(char ch: String.valueOf(count).toCharArray())
                   chars[ptr++] = ch;
           }

           count = 0;
       }

       return ptr;
    }
}