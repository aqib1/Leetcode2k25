class Solution {
    public int fib(int n) {
        return fib(n, 0, 1);
    }

    // using tail recursion to avoid back-tracking
    // Time O(n) and space O(n)
    public int fib(int n, int a, int b) {
        if(n == 0)
            return a;
        if(n == 1)
            return b;

        return fib(n - 1, b, a+b);        
    }
}