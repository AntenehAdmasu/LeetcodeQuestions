class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] arr = new int[row][col];
        int init = obstacleGrid[0][0] == 0 ? 1 : 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int top = i - 1 < 0 ? 0 : arr[i-1][j];
                int left = j - 1 < 0 ? 0 : arr[i][j-1];

                if (obstacleGrid[i][j] == 0){
                    arr[i][j] =  top + left;
                    arr[i][j] += i == 0 & j == 0 ? init : 0;
                }else{
                    arr[i][j] = 0;
                }
            }
        }
        return arr[row-1][col-1];
    }
}