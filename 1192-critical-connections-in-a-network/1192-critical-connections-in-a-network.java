class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // Construct adjacency list
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (List<Integer> c : connections) {
            ArrayList<Integer> neighbours1 = graph.getOrDefault(c.get(0), new ArrayList<Integer>());
            neighbours1.add(c.get(1));
            ArrayList<Integer> neighbours2 = graph.getOrDefault(c.get(1), new ArrayList<Integer>());
            neighbours2.add(c.get(0));

            graph.put(c.get(0), neighbours1);
            graph.put(c.get(1), neighbours2);
        }
        
        int[] ranks = new int[n];
        dfs(graph, 0, 0, 1, ranks);
        return ans;
    }
    
    private int dfs(Map<Integer, ArrayList<Integer>> graph, int curr, int parent, int currRank, int[] ranks) {
        ranks[curr] = currRank;
        for (int nextNode : graph.getOrDefault(curr, new ArrayList<Integer>())) {
            if (nextNode != parent){
                if (ranks[nextNode] > 0){
                    ranks[curr] = Math.min(ranks[curr], ranks[nextNode]);
                }else{
                    ranks[curr] = Math.min(ranks[curr], dfs(graph, nextNode, curr, currRank + 1, ranks));
                }
                if (currRank < ranks[nextNode]){
                    ans.add(Arrays.asList(curr, nextNode));
                }
            } 
           
        }
        return ranks[curr];
    }
}
        