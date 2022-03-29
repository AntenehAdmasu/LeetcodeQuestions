class Solution {
    public int findDuplicate(int[] nums) {

        return findDuplicate(1,nums.length,nums);
    
    }
    
    
    public int findDuplicate(int left, int right, int[] nums) {

        if (right >= left) {
            
            int middle = (left == right) ? left : (left + right - 1) / 2;
            if (getBelowCount(nums, middle) <= middle) {
                return findDuplicate(middle+1, right, nums);
            }
            return findDuplicate(left, middle-1 , nums);
        }
        
        return left;

    }

    
    public int getBelowCount(int[] nums, int n) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= n) count++;
        }
        return count;
    }

}