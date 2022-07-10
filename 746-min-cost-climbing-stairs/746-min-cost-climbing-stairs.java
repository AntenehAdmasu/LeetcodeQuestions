class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if(len == 0) return 0;
        if(len == 1) return cost[0];
        
        for(int i = 2; i < cost.length; i++){
            cost[i] = Math.min(cost[i-1], cost[i-2]) + cost[i];
            
        }
        return Math.min(cost[len-2], cost[len-1]);
        
    }
    
    
}