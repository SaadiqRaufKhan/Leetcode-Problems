class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][k+1][2];

        for(int i=n-1; i>=0; i--) { // stock price
            for(int j=1; j<=k; j++) {   // no. of transactions
                for(int canBuy=1; canBuy>=0; canBuy--) {
                    if(canBuy == 1) {
                        int buy = -prices[i] + dp[i+1][j][0];
                        int skip = dp[i+1][j][1];
                        dp[i][j][canBuy] = Math.max(buy, skip);
                    }
                    else {
                        int sell = prices[i] + dp[i+1][j-1][1];
                        int skip = dp[i+1][j][0];
                        dp[i][j][canBuy] = Math.max(sell, skip);
                    }
                }
            }
        }

        return dp[0][k][1];  
    }
}