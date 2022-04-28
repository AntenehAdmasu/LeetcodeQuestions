class Solution {
    public int minimumEffortPath(int[][] heights) {
        int R = heights.length;
        int C = heights[0].length;
        
        int[][] efforts = new int[R][C];
        for(int[] effort: efforts){
            Arrays.fill(effort, Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->a[2] - b[2]);
        heap.add(new int[]{0, 0, 0});
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        while(!heap.isEmpty()){
            int[] current = heap.poll();
            int row = current[0];
            int col = current[1];
            int effort = current[2];

            if(row == R-1 && col == C-1){
                return effort;
            }
            
            for(int[] dir: directions){
                int newX = row + dir[0];
                int newY = col + dir[1];

                if(newX >= 0 && newX < R && newY >= 0 && newY < C){
                    int newEffort = Math.max(effort, Math.abs(heights[row][col] - heights[newX][newY]));
                    if(newEffort < efforts[newX][newY]){
                        efforts[newX][newY] = newEffort;
                        heap.add(new int[]{newX, newY, newEffort});
                    }
                }
            }
        }
        
        return -1;        
        
    }
}
