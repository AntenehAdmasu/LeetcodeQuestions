class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[(int)Math.round(nums.length/2)];
        
        int difference = 0;
        for(int num: nums){
            difference += Math.abs(num - median);
        }
        return difference;
    }
}