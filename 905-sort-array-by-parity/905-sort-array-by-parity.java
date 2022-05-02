class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int index = 0;

        for (int i = 0; i < n; ++i)
            if (nums[i] % 2 == 0)
                result[index++] = nums[i];

        for (int i = 0; i < n; ++i)
            if (nums[i] % 2 == 1)
                result[index++] = nums[i];

        return result;
    }
}