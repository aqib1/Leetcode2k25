class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length - 1][matrix.length - 1];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int countLessOrEqual = countLessOrEqual(matrix, mid);
            if(countLessOrEqual < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public int countLessOrEqual(int[][] matrix, int mid) {
        int column = matrix.length - 1;
        int row = 0;
        int count = 0;

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