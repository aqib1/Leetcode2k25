class Solution {
    public int compress(char[] chars) {
        int count = 0;
        int pointer = 0;

        for (int i = 0; i < chars.length;) {
            char current = chars[i];
            while (i < chars.length && chars[i] == current) {
                count++;
                i++;
            }
            chars[pointer++] = current;
            if(count > 1) {
                for (char ch : String.valueOf(count).toCharArray()) {
                    chars[pointer++] = ch;
                }
            }
            count = 0;
        }

        return pointer;
    }
}