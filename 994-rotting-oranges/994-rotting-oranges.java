class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<Grid> queue = new LinkedList<>();
        int maxDays = 0;
        int orangeCount = 0;
        int rotten = 0;
        int[][] directions = {
            {0,1}, {0,-1}, {1,0}, {-1,0}
        };
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                orangeCount += grid[i][j] != 0 ? 1 : 0;
                if(grid[i][j] == 2){
                    queue.add(new Grid(i,j,0));
                }
            }
            
        }
        
        while(!queue.isEmpty()){

            Grid current = queue.poll();
            maxDays = Math.max(maxDays, current.days);
            rotten++;
            for(int[] direction: directions){
                int newX = current.x + direction[0];
                int newY = current.y + direction[1];

                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1){
                    Grid newCell = new Grid(newX, newY, current.days + 1);
                    queue.add(newCell);
                    grid[newX][newY] = 2;
                } 
                 
                
            }
            
        }
        return orangeCount == rotten ? maxDays : -1;
        
    }
}


class Grid {

    int x;
    int y;
    int days;
    
    public Grid(int x, int y, int days) {
        this.x = x;
        this.y = y;
        this.days = days;
    }

}