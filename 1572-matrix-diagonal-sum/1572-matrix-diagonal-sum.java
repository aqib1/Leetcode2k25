class Solution {
    public int diagonalSum(int[][] mat) {
        boolean isOdd = mat.length % 2 != 0;
        int sum = 0;

        for(int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
        }

        int j = 0;
        for(int i = mat.length - 1; i >= 0; i--) {
            if(isOdd && i == mat.length / 2) {
                j++;
                continue;
            }
            sum += mat[j++][i];
        }

        return sum;
    }
}