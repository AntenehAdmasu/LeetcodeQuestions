class Solution {
    public int lengthOfLIS(int[] nums) {

            int len = nums.length;
            int[] arr = new int[nums.length];
            int longest = 0;

            for (int i = len-1; i >= 0 ; i--) {
                int max = 1;
                for (int j = i; j < len; j++) {
                    if(nums[i] < nums[j]){
                        max = Math.max(max, arr[j]+1);
                    }
                    arr[i] = max;
                    longest = Math.max(arr[i], longest);
                }

            }
            return longest;
        }
}