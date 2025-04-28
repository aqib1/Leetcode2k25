class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int max = 0;
        var dp = new int[rows + 1][columns + 1];

        for(int i = 1; i < rows + 1; i++) {
            for(int j = 1; j < columns + 1; j++) {
                if(matrix[i - 1][j - 1] == '1') {
                    int left = dp[i][j - 1];
                    int top = dp[i - 1][j];
                    int diagonal = dp[i - 1][j - 1];

                    int min = Math.min(left, Math.min(top, diagonal));

                    dp[i][j] = min + 1;

                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max * max;
    }
}