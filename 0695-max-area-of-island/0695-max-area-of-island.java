class Solution {
    private static final int[] DIRECTION = { 0, -1, 0, 1, 0 };
    private int row;
    private int colum;
    private int currentArea;
    private int maxArea;
    private int[][] grid;

    public int maxAreaOfIsland(int[][] grid) {
        this.row = grid.length;
        this.colum = grid[0].length;
        this.grid = grid;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                if (grid[i][j] == 1) {
                    currentArea = 1;
                    dfs(i, j);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }
        return maxArea;
    }

    private void dfs(int i, int j) {
        grid[i][j] = 0;

        for (int d = 0; d < DIRECTION.length - 1; d++) {
            int newI = i + DIRECTION[d];
            int newJ = j + DIRECTION[d + 1];
            if (newI >= 0 && newI < row
                    && newJ >= 0 && newJ < colum
                    && grid[newI][newJ] == 1) {
                currentArea++;
                dfs(newI, newJ);
            }
        }
    }
}