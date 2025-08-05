class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        pq.offer(new int[] {0,0,0}); // wt, x, y

        int[][] effort = new int[m][n];
        for(int i=0; i<m; i++) {
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }
        effort[0][0] = 0;

        boolean[][] visited = new boolean[m][n];

        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            int wt = node[0];
            int x = node[1];
            int y = node[2];

            visited[x][y] = true;

            for(int[] dir: dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    int eff = Math.max(Math.abs(heights[x][y] - heights[nx][ny]), effort[x][y]);
                    if(eff < effort[nx][ny]) {
                        effort[nx][ny] = eff;
                        pq.offer(new int[] {eff, nx, ny});
                    }
                }
            }
        }
        return effort[m-1][n-1];
    }
}