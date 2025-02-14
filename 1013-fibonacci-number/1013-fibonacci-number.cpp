#include "iostream"
using namespace std;

// Time complexity O(n) and space O(n)
class Solution {
public:
    int fib(int n) {
        if (n == 0 || n == 1)
            return n;
        int last = fib(n - 1);
        int secondLast = fib(n - 2);

        return last + secondLast;
    }
};