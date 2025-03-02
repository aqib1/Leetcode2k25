class Solution {
    public boolean isPalindrome(int x) {
        return x >= 0 && reverse(x) == x;
    }

    private int reverse(int x) {
        int reverse = 0;
        int mul = 1;
        while(x != 0) {
            reverse = reverse * mul + (x % 10);
            x /= 10;
            mul = 10;
        }

        return reverse;
    }
}