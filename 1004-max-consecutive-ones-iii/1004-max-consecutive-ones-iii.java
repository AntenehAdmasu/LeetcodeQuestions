class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int flipCount = 0;
        int longestSoFar = 0;
        int len = nums.length;
        
        while(right < len) {
            if(nums[right] == 0){
                if(flipCount < k){
                    flipCount++;
                }else{
                    while(nums[left] == 1){
                        left++;
                    }
                    left++;
                }
            }
            longestSoFar = Math.max(longestSoFar, right - left + 1);
            right++;
            
            
        }
        return longestSoFar;
    }
}