class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int cell = (board[n-1][0] == -1) ? 1 : board[n-1][0];
        boolean dir = true; // true: l->r, false: r->l
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=n-1; i>=0; i--) {
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

        // System.out.println(map);
        Set<Integer> visited = new HashSet<>();
        int target = n * n;
        int curr = (board[n-1][0] == -1) ? 1 : board[n-1][0];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(curr);
        visited.add(curr);
        int moves = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                int pos = q.poll();
                // if(pos == target) return moves;
                for(int next = pos+1; next <= pos+6; next++) {
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