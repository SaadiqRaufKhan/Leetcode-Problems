class Solution {
    // delta = +1 when placing, -1 when removing
    void fillCells(int[][] board, int row, int col, int delta) {
        int n = board.length;

        // mark column (skip the queen cell here; diagonals will handle it once)
        for (int i = 0; i < n; i++) {
            if (i == row) continue;
            board[i][col] += delta;
        }

        // mark main diagonal (\) - walk to top-left then down-right
        int i = row, j = col;
        while (i > 0 && j > 0) { i--; j--; }
        while (i < n && j < n) {
            board[i][j] += delta;
            i++; j++;
        }

        // mark anti-diagonal (/) - walk to top-right then down-left
        i = row; j = col;
        while (i > 0 && j < n - 1) { i--; j++; }
        while (i < n && j >= 0) {
            board[i][j] += delta;
            i++; j--;
        }

        // The above diagonal loops included (row,col) exactly once;
        // we skipped it in the column loop so total touches = 1.
    }

    void placeQueens(int row, int[][] board, List<List<String>> ans, List<int[]> positions) {
        int n = board.length;
        if (row == n) {
            // placed queens on all rows -> record solution
            List<String> currBoard = new ArrayList<>(n);
            for (int r = 0; r < n; r++) currBoard.add(null);
            for (int[] pos : positions) {
                int r = pos[0], c = pos[1];
                char[] arr = new char[n];
                Arrays.fill(arr, '.');
                arr[c] = 'Q';
                currBoard.set(r, new String(arr));
            }
            ans.add(currBoard);
            return;
        }

        // try placing a queen only in this 'row', across all columns
        for (int col = 0; col < n; col++) {
            if (board[row][col] == 0) { // available
                // mark attacked cells and place queen
                fillCells(board, row, col, +1);
                // mark the queen's own cell (so it becomes non-zero)
                // board[row][col] += 1;

                positions.add(new int[]{row, col});

                // recurse to next row
                placeQueens(row + 1, board, ans, positions);

                // backtrack: remove queen and unmark
                positions.remove(positions.size() - 1);
                // board[row][col] -= 1;
                fillCells(board, row, col, -1);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n]; // 0 => free, >0 => attacked / occupied
        List<List<String>> ans = new ArrayList<>();
        placeQueens(0, board, ans, new ArrayList<>());
        return ans;
    }
}
