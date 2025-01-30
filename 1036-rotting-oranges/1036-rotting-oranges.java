class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // count fresh oranges & push the rotten oranges in the q 
        int freshCount = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new Pair(i,j));
                }
                else if(grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if(freshCount == 0) return 0;   // no fresh orange to begin with

        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int time = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                Pair p = q.poll();
                size--;
                for(int[] d: dir) {
                    int fx = p.x + d[0];
                    int fy = p.y + d[1];
                    if(fx >= 0 && fx < m && fy >= 0 && fy < n) {
                        if(grid[fx][fy] == 1) {
                            grid[fx][fy] = 2;
                            q.offer(new Pair(fx, fy));
                            freshCount--;
                        }
                    }
                }
            }
            time++;
        }

        if(freshCount != 0) return -1;  // fresh oranges still remain
        return time-1;  // adjust time for extra addition
    }
}