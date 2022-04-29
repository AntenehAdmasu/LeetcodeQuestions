class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length]; // Values are 1 or 2
        colors[0] = 1;
        for(int i = 0; i < graph.length; i++){
            int[] edge = graph[i];
            if(colors[i] == 0) colors[i] = 1;
            for(int j = 0; j < edge.length; j++){
                int dest = edge[j];
                int newColor = colors[i] == 1 ? 2 : 1;
                if(colors[dest] == 0){
                    if(!markColors(graph, colors, newColor, dest)){
                        return false;
                    }
                }
            }
        }

        return true;
    }
    
    public boolean markColors(int[][] graph, int[] colors, int newColor, int node){
        colors[node] = newColor;
        for(int dest: graph[node]){
            if(colors[dest] == colors[node]){
                return false;
            }
            int color = newColor == 1 ? 2 : 1;
            if(colors[dest] == 0){
                if(!markColors(graph, colors, color, dest)){
                    return false;
                }
            }
        }
        return true;
    }
}