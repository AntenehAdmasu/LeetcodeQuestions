class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int[][] costDiff = new int[costs.length][2];
        int totalCost = 0;
        for (int i = 0; i < costs.length; i++) {
            costDiff[i] = new int[]{costs[i][0] - costs[i][1], i};
        }
        
        Arrays.sort(costDiff, (a,b) -> a[0] - b[0]);

        for (int i = 0; i < costDiff.length; i++) {
            totalCost += (i < costs.length / 2) ? costs[costDiff[i][1]][0] : costs[costDiff[i][1]][1];
        }
        return totalCost;    
    }
    
}