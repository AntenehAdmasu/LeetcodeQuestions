class Solution {
    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int start = 0;
        int end = n - 1;
        int count = 0;

        while(start < end){
            int pair = k - nums[start];
            while(start < end && nums[end] > pair){
                end--;
            }
            if(start < end){
                if(nums[end] == pair){
                    count++;
                    start++;
                    end--;
                }else{
                    while(start < end && nums[start] + nums[end] < k){
                        start++;
                    }
                }
            }   
        }
        
        return count;

    }
    
}