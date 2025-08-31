class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n*n;

        // check if there is a ladder on the first cell itself or not
        int cell = (board[n-1][0] == -1) ? 1 : board[n-1][0];

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
        
        int start = (board[n-1][0] == -1) ? 1 : board[n-1][0];
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