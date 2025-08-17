class Solution {
    void dfs(List<List<Integer>> rooms, int room, boolean[] visited) {
        if(visited[room]) return;

        visited[room] = true;

        for(int r: rooms.get(room)) {
            if(!visited[r]) dfs(rooms, r, visited);
        }
        return;
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        boolean[] visited = new boolean[n];

        dfs(rooms, 0, visited);

        for(boolean b: visited) {
            if(!b) return false;
        }
        return true;
    }
}