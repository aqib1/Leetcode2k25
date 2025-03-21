class Solution {
    // Time complexity O(n + m) and space O(n + m)
    public void merge(int[] num1, int m, int[] num2, int n) {
        int p = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;

        while(p >= 0) {
            if(p2 < 0)
                break;
            if(p1 >=0 && num1[p1] > num2[p2]) {
                num1[p] = num1[p1--];
            } else {
                num1[p] = num2[p2--];
            }
            p--;
        }
    }
}