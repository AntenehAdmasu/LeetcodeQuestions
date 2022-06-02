class Solution {
    public int[][] transpose(int[][] matrix) {
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        int[][] newArr = new int[cLen][rLen]; 

        for(int i = 0; i < rLen; i ++){
            for(int j = 0;j < cLen; j++){
                newArr[j][i] = matrix[i][j];
            }
        }
        return newArr;
    }
}