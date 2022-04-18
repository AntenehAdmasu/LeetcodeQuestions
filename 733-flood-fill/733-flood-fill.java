class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if(color == newColor) return image;
        image[sr][sc] = newColor;
        
        int[][] directions = new int[][]{{0,1}, {0,-1},{1,0}, {-1,0}};
        for(int[] dir: directions){
            int newR = sr + dir[0];
            int newC = sc + dir[1];
            if(newR >= 0 && newR < image.length && newC >= 0 && newC < image[0].length && image[newR][newC] == color){
                floodFill(image, newR, newC, newColor);
            }
        }
        return image;   
    }
}