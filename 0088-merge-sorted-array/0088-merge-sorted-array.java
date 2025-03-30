class Solution {
    // Time complexity O(n + m) and space O(1)
    public void merge(int[] arr, int m, int[] arr1, int n) {
       int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while(k >= 0) {
            if(j < 0)
                break;
            if(i >= 0 && arr[i] > arr1[j]) {
                arr[k] = arr[i--];
            } else {
                arr[k] = arr1[j--];
            }
            k--;
        }
    }
}