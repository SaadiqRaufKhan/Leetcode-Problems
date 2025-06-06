record Coord(int x, int y) {}
class Solution {
    private void bfs(Deque<Coord> q, boolean[][] visited, int[][] heights, int m, int n) {
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!q.isEmpty()) {
            Coord curr = q.poll();
            int x = curr.x();
            int y = curr.y();

            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n &&
                    !visited[nx][ny] &&
                    heights[nx][ny] >= heights[x][y]) {
                    
                    visited[nx][ny] = true;
                    q.offer(new Coord(nx, ny));
                }
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacificVisited = new boolean[m][n];     // points that can be reached from pacific ocean
        boolean[][] atlanticVisited = new boolean[m][n];    // points that can be reached from atlantic ocean
        
        Deque<Coord> pacificQueue = new ArrayDeque<>();
        Deque<Coord> atlanticQueue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            pacificQueue.offer(new Coord(i, 0));        // left-boundary : touches pacific
            atlanticQueue.offer(new Coord(i, n - 1));   // right-boundary : touches atlantic
            pacificVisited[i][0] = true;
            atlanticVisited[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pacificQueue.offer(new Coord(0, j));        // top-boundary : touches pacific
            atlanticQueue.offer(new Coord(m - 1, j));   // bottom-boundary : touches atlantic
            pacificVisited[0][j] = true;
            atlanticVisited[m - 1][j] = true;
        }

        bfs(pacificQueue, pacificVisited, heights, m, n);
        bfs(atlanticQueue, atlanticVisited, heights, m, n);

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    ans.add(List.of(i, j));
                }
            }
        }

        return ans;
    }
}