class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i][0] -> can't buy ith stock, dp[i][1] -> can buy ith stock
        int[][] dp = new int[n+1][2]; 

        for(int i=n-1; i>=0; i--) {
            for(int canBuy=1; canBuy>=0; canBuy--) {
                // buying state
                if(canBuy == 1) {
                    // buy at todays prices & loose that much money -> switch to can't buy state
                    int buy = dp[i+1][0] - prices[i]; 
                    // skip today's stock -> stay in canBuy state
                    int skip = dp[i+1][1];  
                    dp[i][1] = Math.max(skip, buy);
                }
                // selling state
                else {
                    // sell at today's prices and gain that much amount -> switch to canBuy state
                    int sell = (i+2 < n) ? prices[i] + dp[i+2][1] : prices[i];
                    int skip = dp[i+1][0];
                    dp[i][0] = Math.max(skip, sell);
                }
            } 
        }
        return dp[0][1];
    }
}

/* memoization solution
class Solution {
    int[][] memo;

    int helper(int i, boolean canBuy, int[] prices) {
        if (i >= prices.length) return 0;

        int b = canBuy ? 1 : 0;
        if (memo[i][b] != -1) return memo[i][b];

        int result;
        if (canBuy) {
            // Two choices: buy or skip
            int buy = helper(i + 1, false, prices) - prices[i]; // buy today
            int skip = helper(i + 1, true, prices);       // don't buy today
            result = Math.max(buy, skip);
        } else {
            // Two choices: sell or skip
            int sell = helper(i + 2, true, prices) + prices[i];  // sell today â cooldown tomorrow
            int hold = helper(i + 1, false, prices);             // hold the stock
            result = Math.max(sell, hold);
        }

        memo[i][b] = result;
        return result;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        memo = new int[n][2]; // [day][canBuy: 1/0]
        for(int i=0; i<n; i++) Arrays.fill(memo[i], -1);

        return helper(0, true, prices);
    }
}

*/ 

/* Recursive solution
class Solution {
    int ans = 0;
    void helper(int[] prices, int i, boolean canBuy, int price, int profit) {
        if(i >= prices.length) {
            ans = Math.max(ans, profit);
            return;
        }
        // if not already bought, we can either buy or skip current stock
        if(canBuy) {
            // buy
            helper(prices, i+1, !canBuy, prices[i], profit);
            // skip
            helper(prices, i+1, canBuy, price, profit);
        }
        else {
            // sell
            helper(prices, i+2, !canBuy, -1, profit + (prices[i] - price));
            // skip
            helper(prices, i+1, canBuy, price, profit);
        }
        return;
    }
    public int maxProfit(int[] prices) {
        helper(prices, 0, true, -1, 0);
        return ans;
    }
}
*/