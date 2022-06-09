class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int l = 0;
        int r = numbers.length - 1;
        
        while(l < r){
            int sum = numbers[l] + numbers[r]; 
            if(sum == target){
                result[0] = l + 1;
                result[1] = r + 1;
                l++;
                r--;
            }else if (sum < target){
                l++;
            }else{
                r--;
            }
        }
        return result;
    }
}