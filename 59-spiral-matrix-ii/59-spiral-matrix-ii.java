class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0,top = 0;
        int right = n -1,down = n - 1;
        int count = 1;
        while (left <= right) {
            // Go to the right
            for (int j = left; j <= right; j ++) {
                res[top][j] = count++;
            }
            // Go downwards
            top ++;
            for (int i = top; i <= down; i ++) {
                res[i][right] = count ++;
            }
            
            //Go to the left
            right --;
            for (int j = right; j >= left; j --) {
                res[down][j] = count ++;
            }
            
            // Go up
            down --;
            for (int i = down; i >= top; i --) {
                res[i][left] = count ++;
            }
            left ++;
        }
        return res;
        
    }
}