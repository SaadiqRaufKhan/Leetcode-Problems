class Solution {
    int res = 0;
    void fillCells(int[][] board, int row, int col, int delta) {
        int n = board.length;
        // fill col only, rows are taken care automatically by recursion
        for(int i=0; i<n; i++) {
            board[i][col] += delta;
        }

        // fill the '\' diagonal
        int i = row, j = col;
        while(i > 0 && j > 0) {i--; j--;}    // move to top left
        while(i < n && j < n) {
            board[i++][j++] += delta;
        }

        // fill the '/' diagonal
        i = row; j = col;
        while(i > 0 && j < n - 1) {i--; j++;}  // move to top right
        while(i < n && j >= 0) {
            board[i++][j--] += delta;
        }
    }
    void placeQueens(int row, int[][] board, List<int[]> positions) {
        if(row == board.length) {   // all rows filled with queens
            res++;
            return;
        }
        // find a vacant col
        for(int col=0; col<board.length; col++) {
            if(board[row][col] == 0) {
                fillCells(board, row, col, 1);
                positions.add(new int[] {row, col});

                placeQueens(row + 1, board, positions);

                fillCells(board, row, col, -1);
                positions.remove(positions.size()-1);
            }
        }
    }
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        List<int[]> positions = new ArrayList<>();

        placeQueens(0, board, positions);

        return res;
    }
}