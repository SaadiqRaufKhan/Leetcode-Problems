class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n*n;
        int cell = 1;

        // store the cell->destination mapping with snakes and ladders 
        Map<Integer, Integer> map = new HashMap<>();

        boolean dir = true; // true: l->r, false: r->l
        for(int i=n-1; i>=0; i--) {
            if(cell == target) break;
            if(dir) {   // move: l->r
                for(int j=0; j<n; j++) {
                    if(board[i][j] != -1) map.put(cell, board[i][j]);
                    cell++;
                }
                dir = !dir;
            }
            else {      // move: r->l
                for(int j=n-1; j>=0; j--) {
                    if(board[i][j] != -1) map.put(cell, board[i][j]);
                    cell++;
                }
                dir = !dir;
            }
        }

        // visited cells
        Set<Integer> visited = new HashSet<>();
        
        int start = 1;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited.add(start);

        int moves = 1;
        // bfs
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                int pos = q.poll();
                for(int next = pos+1; next <= pos+6; next++) {
                    // check if next has a snake/ladder mapping or not
                    int trueNext = map.getOrDefault(next, next);    
                    if(!visited.contains(trueNext)) {
                        if(trueNext == target) return moves;
                        q.offer(trueNext);
                        visited.add(trueNext);
                    }
                }
                size--;
            }
            moves++;
        }
        return -1;
    }
}

// optimized with array instead of map/set for mappings and visited
// class Solution {
//     public int snakesAndLadders(int[][] board) {
//         int n = board.length;
//         int[] jumps = new int[n*n + 1]; 
//         Arrays.fill(jumps, -1);

//         // Convert board to linear mapping
//         int cell = 1;
//         boolean dir = true;
//         for (int i = n - 1; i >= 0; i--) {
//             if (dir) {
//                 for (int j = 0; j < n; j++) {
//                     if (board[i][j] != -1) jumps[cell] = board[i][j];
//                     cell++;
//                 }
//             } else {
//                 for (int j = n - 1; j >= 0; j--) {
//                     if (board[i][j] != -1) jumps[cell] = board[i][j];
//                     cell++;
//                 }
//             }
//             dir = !dir;
//         }

//         // BFS
//         Queue<Integer> q = new ArrayDeque<>();
//         boolean[] visited = new boolean[n*n + 1];
//         q.offer(1);
//         visited[1] = true;

//         int moves = 0;
//         while (!q.isEmpty()) {
//             int size = q.size();
//             while (size-- > 0) {
//                 int pos = q.poll();
//                 if (pos == n*n) return moves;
//                 for (int dice = 1; dice <= 6 && pos + dice <= n*n; dice++) {
//                     int next = pos + dice;
//                     if (jumps[next] != -1) next = jumps[next];
//                     if (!visited[next]) {
//                         visited[next] = true;
//                         q.offer(next);
//                     }
//                 }
//             }
//             moves++;
//         }
//         return -1;
//     }
// }
