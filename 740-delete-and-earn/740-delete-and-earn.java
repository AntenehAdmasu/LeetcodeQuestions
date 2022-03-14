class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] dp = new int[10001];
        for(int num: nums){
            dp[num] += num++;
        }

        for(int i = 0; i < dp.length; i++){
            int jump = i-2 < 0 ? 0 : dp[i-2];
            int adj = i-1 < 0 ? 0 : dp[i-1];
            dp[i] = Math.max(jump + dp[i], adj);
        }

        return dp[10000];
    }
}