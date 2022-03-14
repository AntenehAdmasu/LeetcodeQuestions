class Solution {
    
    public int numberOfSubarrays(int[] nums, int k) {
        
        int n = nums.length, ans = 0, sum = 0;
        int[] visited = new int[n + 1];
        visited[0] = 1;

        for (int i = 0; i < n; i++) {
            sum += nums[i] % 2;
            ans += (sum < k ? 0 : visited[sum - k]);
            visited[sum]++;
        }
        return ans;
    }
    
}