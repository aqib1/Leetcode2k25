class Solution {
    public void merge(int[] num1, int m, int[] num2, int n) {
       if (num2.length == 0)
            return;
        int i = m - 1;
        int j = n - 1;
        int k = (m + n) - 1;

        while(j >= 0) {
            if(i >= 0 && num1[i] >= num2[j]) {
                num1[k--] = num1[i--];
            } else {
                num1[k--] = num2[j--];
            }
        }
    }
}