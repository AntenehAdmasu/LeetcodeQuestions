class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int start1 = n - (k % n);  
        int end1 = n - 1;
        int start2 = 0;
        int end2 = start1 - 1;
        
        reverse(nums, start1, end1);
        reverse(nums, start2, end2);
        reverse(nums, 0, n-1);
        
    }
    
    public void reverse(int[] nums, int start, int end){
        while(start >= 0 && start < end && end < nums.length){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

