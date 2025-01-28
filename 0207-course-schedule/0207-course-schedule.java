class Solution {

    public boolean dfs(boolean[][] graph, int node, boolean[] visited, boolean[] recStack) {
        // If the node is already in the recursion stack, a cycle is detected
        if (recStack[node]) {
            return true;
        }

        // If the node is already visited and not in the recursion stack, no need to explore further
        if (visited[node]) {
            return false;
        }

        // Mark the node as visited and add it to the recursion stack
        visited[node] = true;
        recStack[node] = true;

        // Explore all neighbors
        for (int i = 0; i < graph.length; i++) {
            if (graph[node][i]) { // If there is an edge from node to i
                if (dfs(graph, i, visited, recStack)) {
                    return true; // Cycle detected
                }
            }
        }

        // Remove the node from the recursion stack after exploring
        recStack[node] = false;

        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build the adjacency matrix
        boolean[][] graph = new boolean[numCourses][numCourses];
        for (int[] arr : prerequisites) {
            graph[arr[0]][arr[1]] = true;
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        // Perform DFS for each node
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(graph, i, visited, recStack)) {
                    return false; // Cycle detected
                }
            }
        }

        return true; // No cycle detected
    }
}
