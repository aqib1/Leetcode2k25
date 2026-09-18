class Solution {
    public void setZeroes(int[][] matrix) {
        var xIndex = new HashSet<Integer>();
        var yIndex = new HashSet<Integer>();

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    xIndex.add(i);
                    yIndex.add(j);
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(xIndex.contains(i) || yIndex.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}