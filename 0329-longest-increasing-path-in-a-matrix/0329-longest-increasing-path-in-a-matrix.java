class Solution {
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    int dfs(int[][] matrix, int[][] dp, int x, int y) {
        if(dp[x][y] != 0) return dp[x][y];

        dp[x][y] = 1; // minimum possible ans for current cell
        for(int[] dir: dirs) {
            int xn = x + dir[0];
            int yn = y + dir[1];

            if(xn >= 0 && xn < dp.length && yn >= 0 && yn < dp[0].length
                && matrix[xn][yn] > matrix[x][y]) {
                dp[x][y] = Math.max(dp[x][y], 1 + dfs(matrix, dp, xn, yn));
            }
        }
        return dp[x][y];

    }
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // dp[i][j] -> Longest inc path starting from this cell  
        int[][] dp = new int[m][n];

        // apply dfs on each cell with memoization
        // visited is not required, because we can only make calls to larger elements
        int ans = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(dp[i][j] == 0) {
                    ans = Math.max(ans, dfs(matrix, dp, i, j));
                }
            }
        }
        return ans;
    }
}