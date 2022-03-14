class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3){
            return 0;
        }
        int diff = nums[1] - nums[0];
        int sequence = 1;
        int subarrays = 0;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[i-1] == diff){
                sequence++;
                // Every additional element can form (n - 2) subarrays 
                if(sequence > 2){
                    subarrays += sequence - 2;
                }
            }else{
                sequence = 1;
                diff = nums[i] - nums[i-1];
                i--; // because this index can be a start of a new sequence
            }
        }
        return subarrays;
    }
}