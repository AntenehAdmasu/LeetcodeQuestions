class Solution {
    public int maximumDetonation(int[][] bombs) {
        int size = bombs.length;
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if(i == j){
                    continue;
                }
                // Calculate the distance
                boolean inRange = withInRange(bombs, i, j);
                if(inRange){
                    List<Integer> neighbours = adjacencyList.getOrDefault(i, new ArrayList<>());
                    neighbours.add(j);
                    adjacencyList.put(i, neighbours);
                }
            }
        }
        
        HashSet<Integer> visited = new HashSet<>();
        int maxCount = 1;
        for(int i = 0; i < size; i++){
            visited = new HashSet<>();
            if(!visited.contains(i)){
                visited.add(i);
                int count = dfs(i, visited, adjacencyList);
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
    
    
    private int dfs(int index, HashSet<Integer> visited, HashMap<Integer, List<Integer>> adjacencyList){
        int count = 1;
        List<Integer> neighbours = adjacencyList.get(index);
        if(neighbours != null){
            for(int neighbourIndex: neighbours){
                if(!visited.contains(neighbourIndex)){
                    visited.add(neighbourIndex);
                    count += dfs(neighbourIndex, visited, adjacencyList);
                }
            }
        }
        
        return count;
    }
    
    private boolean withInRange(int[][] bombs, int bomb1, int bomb2){

        int r1 = bombs[bomb1][2];
        int x1 = bombs[bomb1][0];
        int y1 = bombs[bomb1][1];
        int x2 = bombs[bomb2][0];
        int y2 = bombs[bomb2][1];
        
        double distance = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2 - y1, 2));
        return distance <= r1;
        
    }
    
    
}