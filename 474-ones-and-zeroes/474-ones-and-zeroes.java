class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        
        int[][] dp = new int[m+1][n+1];
        for(int k = 0; k < len; k++){
            String str = strs[k];
            int zeros = 0;
            for(char c: str.toCharArray()){
                zeros += c == '0' ? 1 : 0;
            }
            int ones = str.length() - zeros;
            
            for(int i = m; i >= zeros; i--){
                for(int j = n; j >= ones; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
	}
}