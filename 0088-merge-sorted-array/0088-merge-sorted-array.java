class Solution {
    public void merge(int[] num1, int m, int[] num2, int n) {
       int[] res = new int[m + n];
        int i = 0, j = 0, k = 0;
        while(i < m && j < n) {
            if(num1[i] < num2[j]) {
                res[k++] = num1[i++];
            } else {
                res[k++] = num2[j++];
            }
        }

        while(i < m) {
            res[k++] = num1[i++];
        }

        while(j < n) {
            res[k++] = num2[j++];
        }

        System.arraycopy(res, 0, num1, 0, res.length);
    }
}