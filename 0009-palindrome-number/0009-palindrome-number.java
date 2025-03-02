class Solution {
    public boolean isPalindrome(int x) {
        return x >= 0 && reverse(x) == x;
    }

    private int reverse(int x) {
        int reverse = 0;
        while(x != 0) {
            reverse = reverse * 10 + (x % 10);
            x /= 10;
        }

        return reverse;
    }
}