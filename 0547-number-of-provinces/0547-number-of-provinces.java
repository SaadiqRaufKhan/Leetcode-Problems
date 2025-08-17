class Solution {
    void dfs(int[][] graph, int city, boolean[] visited) {
        visited[city] = true;

        for(int i=0; i<graph.length; i++) {
            if(!visited[i] && graph[city][i] == 1) {
                dfs(graph, i, visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        int ans = 0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(isConnected, i, visited);
                ans++;
            }
        }
        return ans;
    }
}