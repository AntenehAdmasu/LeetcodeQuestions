class Solution {
    public boolean makesquare(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i : nums)
            sum += i;
        if(sum % 4 != 0 || nums.length < 4)
           return false;
        int target = sum  / 4;
                
        return match(nums, nums.length-1, 0, 0, 0, 0, target);
    }
    
    public boolean match(int[] matchsticks, int index, int side1, int side2, int side3, int side4, int target) {
        
        if (side1 == target && side2 == target && side3 == target && side4 == target) return true;

        if (side1 > target || side2 > target || side3 > target || side4 > target) return false;
                        
        int val = matchsticks[index];
        
        boolean s1 = match(matchsticks, index - 1, side1 + val, side2, side3, side4, target);
        if (s1) return true;
        boolean s2 = match(matchsticks, index - 1, side1, side2 + val, side3, side4, target);
        if (s2) return true;
        boolean s3 = match(matchsticks, index - 1, side1, side2, side3 + val, side4, target);
        if (s3) return true;
        boolean s4 = match(matchsticks, index - 1, side1, side2, side3, side4 + val, target);
        if (s4) return true;
        
        return false;
    }

}