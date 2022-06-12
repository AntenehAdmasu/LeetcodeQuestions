class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int result = 0;
        int left = 0;
        int right = 0;
        Set<Integer> numSet =  new HashSet();
                
        while(left < len && right < len){    
            int numRight = nums[right];
            int numLeft = nums[left];
            if(!numSet.contains(numRight)){
                sum += numRight;
                result = Math.max(result, sum);
                numSet.add(numRight);
                right++;
            }else{   
                sum -= numLeft;
                numSet.remove(numLeft);
                left++;
            }
        }

        return result;
    }
}