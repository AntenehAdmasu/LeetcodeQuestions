class Solution {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        int fails = 0;
        int failIndex = -1;
        for(int i = 0; i < n - 1; i++){
            if(nums[i] > nums[i+1]){
                fails++;
                failIndex = i;
            }
            // Quiting early if 2 fails are found
            if(fails > 1){
                return false;
            }
        }
        // If the fail is at the beginning or the end it can be modified to give a non-decreasing array
        if(failIndex <= 0 || failIndex == n-2){
            return true;
        }else if(fails == 1){
            // Modifying at where the sequence failed
            boolean editFail = nums[failIndex - 1] <= nums[failIndex+1];
            // Modifying the element next to the fail
            boolean editNext = nums[failIndex] <= nums[failIndex+2];
            return editFail || editNext;
        }
        return true;
    }
}