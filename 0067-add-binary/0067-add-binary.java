class Solution {

    // Time complexity O(n) and space O(n)
    public String addBinary(String a, String b) {
        var builder = new StringBuilder();

        var carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while(i >= 0 || j >= 0 || carry > 0) {
            if (i >= 0) {
                carry += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += b.charAt(j--) - '0';
            }
            builder.append(carry % 2);
            carry /= 2;
        }

        return builder.reverse().toString();
    }
}