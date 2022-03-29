class Solution {
    public int findDuplicate(int[] nums) {
        return swap(nums, 0);
    }
    
    public int swap(int[] nums, int number){
        // If the position is already taken, then this number is the duplicate
        if(nums[number] == number){
            return number;
        }
        int displaced = nums[number];
        nums[number] = number;
        return swap(nums, displaced);
        
    }
}