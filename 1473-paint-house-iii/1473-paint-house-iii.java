// TO BE REDONE
class Solution {
   public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m][n][target+1];
        
        for(int i = 0; i < m; i++) for(int j = 0; j < n; j++) for(int k=0; k <= target; k++) dp[i][j][k] = -1;
        
        for(int i = 0; i < n; i++) {
            if (houses[0] == 0){
                dp[0][i][1]=cost[0][i];
            } else if (houses[0] == i+1){
                dp[0][i][1] = 0;
            }
        }
        
        for(int i = 1; i < m; i++) {
            for(int t = 1; t <= target && t <= i+1; t++) {  
                for(int j = 0; j < n; j++) {
                    if (houses[i] != 0 && houses[i] != j+1) continue;
                    int costToPaint = houses[i]==j+1 ? 0 : cost[i][j];
                    
                    for(int k = 0; k < n; k++) {
                        if (j == k && dp[i-1][k][t] != -1) {
                            dp[i][j][t] = (dp[i][j][t] == -1) ?
                                (costToPaint + dp[i-1][k][t]) :
                                (Math.min(dp[i][j][t], costToPaint + dp[i-1][k][t]));
                        }
                        else if (j != k && dp[i-1][k][t-1] != -1) {
                            dp[i][j][t] = (dp[i][j][t] == -1) ?
                                (costToPaint + dp[i-1][k][t-1]) :
                                (Math.min(dp[i][j][t], costToPaint + dp[i-1][k][t-1]));
                        }
                    }
                }   
            }
        }
        
        int ans = -1;
        for(int i = 0; i < n; i++) {
            if (dp[m-1][i][target] != -1) ans = ans == -1 ? dp[m-1][i][target] : Math.min(ans,dp[m-1][i][target]);
        }
        return ans;
    }
}