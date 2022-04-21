class Solution {
    int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {        
        HashMap<String, Integer> lookup = new HashMap<>();
        int maxSequence = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length ; j++) {
                String cell = i + "|" + j;
                if(lookup.containsKey(cell)){
                    continue;
                }
                int sequenceLength = DFSTraverse(i, j, lookup, matrix);
                maxSequence = Math.max(maxSequence,sequenceLength);
            }
        }
        
        return maxSequence;
    }
    
    
    
    private int DFSTraverse(int row, int col, HashMap<String, Integer> lookup, int[][] matrix) {
        String cell = row + "|" + col;
        if (lookup.containsKey(cell)) {
            return lookup.get(cell);
        }

        int max = 0;
        for(int[] dir: directions){
            int newR = row + dir[0];
            int newC = col + dir[1];
            if(newR >= 0 && newR < matrix.length && newC >= 0 && newC < matrix[0].length && matrix[newR][newC] > matrix[row][col]){
                max = Math.max(max, DFSTraverse(newR, newC, lookup, matrix));
            }
        }
        
        lookup.put(cell, max + 1);
        return max + 1;
    }
}
