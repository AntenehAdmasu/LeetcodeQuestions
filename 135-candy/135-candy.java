class Solution {
    public int candy(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int total = 0;
        // Go from left to right and find a monotonic sequence
        for(int i = 0; i < len; i++){
            int prev = i == 0 ? nums[0] - 1 : nums[i-1];
            result[i] = 1;
            if(nums[i] > prev){
                int prevVal = i == 0 ? 0 : result[i-1];
                result[i] = prevVal + 1;
            }
            total += result[i];
        }

        // Go from right to left and find a monotonic sequence and update values
        for(int j = len-1; j >= 0; j--){
            int right = j == len-1 ? nums[len-1] - 1 : nums[j+1];
            if(nums[j] > right){
                int prevVal = j == len-1 ? 0 : result[j+1];
                total -= result[j];
                result[j] = Math.max(result[j],prevVal + 1);
                total += result[j];
            }
        }
        return total;
    }
}