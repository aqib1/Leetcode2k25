class Solution {
    public int fib(int n) {
        if(n == 0)
            return n;
        
        var tabulation = new int[n + 1];
        tabulation[0] = 0;
        tabulation[1] = 1;

        for(int i = 2; i <= n; i++) {
            tabulation[i] = tabulation[i - 1] + tabulation[i - 2];
        }

        return tabulation[n];
    }

    public int fib(int n, int[] memoization) {
        if(n == 0 || n == 1)
            return n;
        if(memoization[n] != 0)
            return memoization[n];

        memoization[n] = fib(n - 1, memoization) + fib(n - 2, memoization);
        return memoization[n];
    }
}