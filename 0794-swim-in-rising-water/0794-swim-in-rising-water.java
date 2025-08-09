class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        boolean[][] visited = new boolean[n][n];

        int[][] dist = new int[n][n];
        for(int i=0; i<n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = grid[0][0];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));    
        pq.offer(new int[] {0, 0, 0});  // {dist, x, y}

        int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};
        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            int curr_dist = node[0];
            int x = node[1];
            int y = node[2];

            if(x == n-1 && y == n-1) break;

            visited[x][y] = true;

            for(int[] dir: dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    int new_dist = Math.max(dist[x][y], grid[nx][ny]);
                    dist[nx][ny] = Math.min(dist[nx][ny], new_dist);

                    pq.offer(new int[] {dist[nx][ny], nx, ny});
                }
            }
        }

        return dist[n-1][n-1];
    }
}