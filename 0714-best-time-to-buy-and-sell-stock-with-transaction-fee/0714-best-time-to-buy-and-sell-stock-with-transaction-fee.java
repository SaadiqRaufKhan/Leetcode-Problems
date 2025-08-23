class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        for(int i=n-1; i>=0; i--) {
            for(int canBuy=1; canBuy>=0; canBuy--) {    // canBuy = 1: buy/skip, canBuy = 2: sell/skip
                if(canBuy == 1) {   // buying state
                    int buy = -prices[i] + dp[i+1][0];
                    int skip = dp[i+1][1];
                    dp[i][1] = Math.max(buy, skip);
                }
                else {      // selling state
                    int sell = prices[i] + dp[i+1][1] - fee;
                    int skip = dp[i+1][0];
                    dp[i][0] = Math.max(sell, skip);
                }
            }
        }
        
        return dp[0][1];
    }
}