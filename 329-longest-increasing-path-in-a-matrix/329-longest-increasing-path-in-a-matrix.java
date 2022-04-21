class Solution {
    int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] lookup = new int[n][m];
        int maxSequence = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String cell = i + "|" + j;
                if(lookup[i][j] != 0){
                    continue;
                }
                int sequenceLength = DFSTraverse(i, j, lookup, matrix);
                maxSequence = Math.max(maxSequence,sequenceLength);
            }
        }
        
        return maxSequence;
    }
    
    private int DFSTraverse(int row, int col, int[][] lookup, int[][] matrix) {        
        if (lookup[row][col] != 0) {
            return lookup[row][col];
        }

        int max = 0;
        for(int[] dir: directions){
            int newR = row + dir[0];
            int newC = col + dir[1];
            if(newR >= 0 && newR < matrix.length && newC >= 0 && newC < matrix[0].length && matrix[newR][newC] > matrix[row][col]){
                max = Math.max(max, DFSTraverse(newR, newC, lookup, matrix));
            }
        }
        
        lookup[row][col] = max + 1;
        return max + 1;
    }
}
