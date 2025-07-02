class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount+1];

        // fill the 0th col: 
        // 0 amount is always possible in 1 way, by not taking any coin
        for(int i=0; i<n; i++) {
            dp[i][0] = 1;
        }
        // fill the 0th row:
        // if any amount is a multiple of the 0th coin then fill it with 1
        for(int currAmount=1; currAmount<=amount; currAmount++) {
            if(currAmount % coins[0] == 0) {
                dp[0][currAmount] = 1;
            }
        }

        // fill the remaining dp table
        for(int i=1; i<n; i++) {
            for(int j=1; j<=amount; j++) {
                int notTaken = dp[i-1][j];
                int taken = 0;
                if(coins[i] <= j) {
                    taken = dp[i][j-coins[i]];
                }
                dp[i][j] = taken + notTaken;
            }
        }

        return dp[n-1][amount];

    }
}