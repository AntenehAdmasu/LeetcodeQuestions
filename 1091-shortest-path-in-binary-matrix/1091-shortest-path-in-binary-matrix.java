class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        LinkedList<int[]> queue = new LinkedList<>();
        int[][] directions = new int[][]{{-1,-1}, {-1,0}, {-1,1}, {1,-1}, {1,0}, {1,1}, {0,-1}, {0, 1}};
        if(grid[0][0] == 0){
            queue.add(new int[]{0,0,1});
            grid[0][0] = 1; 
        }
        int level = 0;
        while (!queue.isEmpty()){
            int[] cell = queue.pop();
            if(cell[0] == grid.length - 1 && cell[1] == grid[0].length - 1){
                return cell[2];
            }
            for(int[] direction: directions){
                int newX = cell[0] + direction[0];
                int newY = cell[1] + direction[1];
                if(newX < grid.length && newX >= 0 && newY < grid[0].length && newY >= 0 && grid[newX][newY] == 0){
                    grid[newX][newY] = 1;
                    queue.add(new int[]{newX, newY, cell[2] + 1});
                }
            }
            
        }
        return -1;
    }
}