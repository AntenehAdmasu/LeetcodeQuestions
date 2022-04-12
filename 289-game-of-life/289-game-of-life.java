class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] result = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int liveNeighbours = getLiveNeighbours(board, i, j);
                if(board[i][j] == 1){
                    if(liveNeighbours < 2){
                        result[i][j] = 0;
                    }else if (liveNeighbours < 4){
                        result[i][j] = 1;
                    }else if(liveNeighbours > 3){
                        result[i][j] = 0;
                    }
                }else {
                    if(liveNeighbours == 3){
                        result[i][j] = 1;
                    }
                }
            }
        }
        
        for(int i = 0; i < n; i++){
                board[i] = result[i];
        }
        board = result;
    }
    
    public int getLiveNeighbours(int[][] board, int r, int c){
        int liveNeighbours = 0;
        int[][] neighbours = new int[][]{
            new int[]{1,0},
            new int[]{1,1},
            new int[]{1,-1},
            new int[]{0,1},
            new int[]{0,-1},
            new int[]{-1,-1},
            new int[]{-1,0},
            new int[]{-1,1},            
        };
        for(int[] neighbour: neighbours){
            int newX = r + neighbour[0];
            int newY = c + neighbour[1];
            if(newX >= 0 && newX < board.length & newY >= 0 && newY < board[0].length && board[newX][newY] == 1){
                liveNeighbours++;
            }
        }
        return liveNeighbours;
    }
}