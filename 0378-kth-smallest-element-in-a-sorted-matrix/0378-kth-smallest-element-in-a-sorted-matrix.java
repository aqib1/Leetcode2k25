class Solution {
    // We will use range based binary search
    // Time complexity O(NLog(max - min)) and space O(1)
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0]; // smallest number
        int high = matrix[matrix.length - 1][matrix.length - 1]; // largest number

        // let's use all number in between (max - min)
        while(low < high) {
            int mid = low + (high - low) / 2;
            int countLessThanOrEqual = countLessThanOrEqual(mid, matrix);
            if(countLessThanOrEqual < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int countLessThanOrEqual(int mid, int[][] matrix) {
        int count = 0;
        int column = matrix.length - 1;
        int row = 0;

        while(column >= 0 && row < matrix.length) {
            if(matrix[row][column] <= mid) {
                count += (column + 1);
                row++;
            } else {
                column--;
            }
        }

        return count;
    }
}