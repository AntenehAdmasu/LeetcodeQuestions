class Solution {
    public boolean find132pattern(int[] nums) {
        Stack <Integer> stack = new Stack ();
        int right = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            // If num is less than right, it is also less than middle(the one on top of the stack)
            // because if right is not Interger.MIN there is a bigger value than right
            if (nums [i] < right){
                return true;
            }

            // nums[i] is set to right when a bigger value is found
            while (!stack.isEmpty() && nums [i] > stack.peek ()){
                right = stack.pop(); // Continuously update the right min
            }
            stack.push (nums[i]);
        }
        return false;
    }
}