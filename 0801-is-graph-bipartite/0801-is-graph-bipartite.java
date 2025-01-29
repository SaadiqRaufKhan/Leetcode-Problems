class Solution {
    boolean dfs(int[][] graph, int node, int[] color, int currCol) {
        color[node] = currCol;
        
        for(int adjNode: graph[node]) {
            if(color[adjNode] == 0) {   // i.e. uncolored
                if(!dfs(graph, adjNode, color, currCol * -1)) {
                    return false;
                }
            }
            else if(color[adjNode] == currCol) {
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        // input is an edge list
        // -1/1 are the 2 colors, 0 denotes uncolored
        int[] color = new int[graph.length];  

        for(int i=0; i<graph.length; i++) {
            if(color[i] == 0) {
                if(!dfs(graph, i, color, 1)) {
                    return false;
                }
            }
        }

        return true;

    }
}