class Solution {
    private static final int[] DIRECTION = {0, 1, 0, -1, 0};
    public int numIslands(char[][] grid) {
        int count = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    markIsland(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public void markIsland(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        for(int d = 0; d < DIRECTION.length - 1; d++) {
            int newX = i + DIRECTION[d];
            int newY = j + DIRECTION[d + 1];
            if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[newX].length && grid[newX][newY] == '1')
                markIsland(grid, newX, newY);
        }
    }
}