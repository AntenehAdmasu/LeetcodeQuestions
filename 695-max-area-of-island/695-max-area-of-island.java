class Solution {
    public int size = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int island = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    size = 0;
                    if (dfs(grid, i, j)){
                        island = Math.max(island, size);
                    }
                }
            }
        }
        return island;
    }
    
    private boolean dfs(int[][] grid, int row, int col) {
        if(row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] == 0){
            return true;
        }
        
        size++;
        grid[row][col] = 0;
        boolean left = dfs(grid, row, col-1);
        boolean right = left && dfs(grid, row, col+1);
        boolean up = right && dfs(grid, row-1, col);
        boolean down = up && dfs(grid, row+1, col);
        
        return down;
    }
}