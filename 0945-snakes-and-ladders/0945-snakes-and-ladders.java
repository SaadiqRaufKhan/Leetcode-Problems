class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n*n;

        // check if there is a ladder on the first cell itself or not
        // int cell = (board[n-1][0] == -1) ? 1 : board[n-1][0];
        int cell = 1;

        // store the cells with all the snakes and ladders
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

        Set<Integer> visited = new HashSet<>();
        // int start = (board[n-1][0] == -1) ? 1 : board[n-1][0];
        int start = 1;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited.add(start);
        int moves = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                int pos = q.poll();
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