class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int width = Math.min(height[start], height[end]) * (end - start);
        int maxWidth = Math.max(0,width);

        while(end > start){
            int tempWidth = end - start;
            int tempHeight = Math.min(height[end], height[start]);
            maxWidth = Math.max(maxWidth, (tempWidth * tempHeight));
            if(height[end] < height[start]){
                end--;
            }else{
                start++;
            }
        }
        return maxWidth;
    }
}