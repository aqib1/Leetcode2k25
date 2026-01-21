class Solution {
    public void merge(int[] num1, int m, int[] num2, int n) {
        if (num2.length == 0)
            return;

        int i = 0, j = 0;
        while (i < m && j < n) {
            if (num2[j] < num1[i]) {
                for (int l = m; l > i; l--) {
                    num1[l] = num1[l - 1];
                }

                num1[i] = num2[j];
                m++;
                j++;
            }
            i++;
        }

        while (j < n) {
            num1[i++] = num2[j++];
        }

    }
}