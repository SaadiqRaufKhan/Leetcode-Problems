class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] boardRef = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                boardRef[i][j] = board[i][j];
            }
        }

        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int alive = 0;
                int dead = 0;
                for(int[] dir: dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if(x >= 0 && x < m && y >= 0 && y < n) {
                        if(boardRef[x][y] == 1) alive++;
                        else dead++;
                    }
                }
                if(boardRef[i][j] == 1 && (alive < 2 || alive > 3)) {
                    board[i][j] = 0;
                }
                else if(boardRef[i][j] == 0 && alive == 3) {
                    board[i][j] = 1;
                } 
            }
        }
    }
}