#include "iostream"
using namespace std;

// Time complexity O(n) and space O(n)
class Solution {
public:
    int fib(int n) {
        if(n == 0)
            return 0;

        vector<int> memoization(n+1);
        memoization[0] = 0;
        memoization[1] = 1;
        for (int x = 2; x <= n; x++) {
            memoization[x] = memoization[x - 1] + memoization[x - 2];
        }

        return memoization[n];
    }
};