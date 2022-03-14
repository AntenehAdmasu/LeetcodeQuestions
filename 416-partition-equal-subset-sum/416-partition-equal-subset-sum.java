class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        int n = nums.length;
        for(int num: nums){
            total += num;
        }
        Arrays.sort(nums);
        if(total % 2 != 0) {
            return false;
        }
        int target = total / 2;
        HashMap<String, Boolean> memo = new HashMap<>();
        boolean found = collectSubsetSum(nums, 1, nums[0], target, memo) || collectSubsetSum(nums, 1, 0, target, memo);
        return found;
    }
    
    public boolean collectSubsetSum(int[] nums, int index, int acc, int target, HashMap<String, Boolean> memo) {
        String current = index + "," + acc;
        if(memo.containsKey(current)){
            return memo.get(current);
        }
        if(acc > target || index == nums.length){
            return false;
        }
        if(acc == target){
            return true;
        }
        
        boolean result = collectSubsetSum(nums, index + 1, acc + nums[index],target, memo) || collectSubsetSum(nums, index + 1, acc, target, memo);
        memo.put(current, result);
        return result;
        
    }
}