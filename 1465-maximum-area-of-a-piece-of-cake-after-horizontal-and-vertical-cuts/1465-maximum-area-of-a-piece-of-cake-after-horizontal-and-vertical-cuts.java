class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long MOD = (long)1e9+7;
        long maxHeight = 0;
        long maxWidth = 0;

        for(int i = 0; i <= horizontalCuts.length; i++){
            int right = i == horizontalCuts.length ? h : horizontalCuts[i];
            int left = i == 0 ? 0 : horizontalCuts[i-1];
            maxHeight = Math.max(maxHeight, right - left);
        }
        
        for(int j = 0; j <= verticalCuts.length; j++){
            int bottom = j == verticalCuts.length ? w : verticalCuts[j];
            int top = j == 0 ? 0 : verticalCuts[j-1];
            maxWidth = Math.max(maxWidth, bottom - top);
        }
        
        return (int)((maxHeight * maxWidth) % MOD);
    }
}