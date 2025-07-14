class Solution {
public:
    // dp[k, i] represents the max profit up until prices[i] (Note: NOT ending with prices[i]) using at most k transactions. 
    // dp[k, i] = max(dp[k][i-1], prices[i] - prices[j] + dp[k-1, j]) { j in range of [0, i-1] }
    //          = max(dp[k][i-1], prices[i] + max(dp[k-1, j] - prices[j])) {rearranging the terms}
        
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        if (n <= 1) return 0;

        vector<vector<int>> dp(3, vector<int>(n, 0));

        for (int k = 1; k <= 2; k++) {
            int temp_max = dp[k-1][0] - prices[0];  // we've bought the stock 0th day
            for (int i = 1; i < n; i++) {
                // either we skip and don't sell on the ith day, or we sell the stock having it bought previously
                dp[k][i] = max(dp[k][i-1], prices[i] + temp_max);
                temp_max = max(temp_max, dp[k-1][i] - prices[i]);   // buying on ith day to see if profit improves
                // the line above helps us by not having separate varaible 'j' to iterate in the 0 to i-1 range
            }
        }
        return dp[2][n-1];
    }
};


/* brute force approach, divide array in 2 parts, call simple maxProfit on both
    // this is the regular max profit function
    int helper(vector<int>& prices, int s, int e) {
        int minTillNow = prices[s];
        int ans = 0;
        
        for(int i=s; i<=e; i++) {
            ans = max(ans, prices[i] - minTillNow);
            minTillNow = min(minTillNow, prices[i]);
        }
        return ans;
    }
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        int ans = 0;
        for(int j=0; j<n; j++) {
            int lans = helper(prices, 0, j);
            int rans = helper(prices, j, n-1);
            ans = max(ans, lans+rans);
        }
        return ans;
    }


    -----------------------------------------

    int n = prices.size();
        // 3 x n dp : 3 because we max transcn = 2
        vector<vector<int> > dp(3, vector<int>(n+1, 0));
        int ans = 0;
        
        // here k=2, general case of k variant
        for(int i=1; i<=2; i++) {
            for(int j=n-2; j>=0; j--) {
                int notBuy = dp[i][j+1];
                int buy = 0;
                for(int jj=j+1; jj<n; jj++) {
                    if(prices[jj] > prices[j]) {
                        // one less transaction and stocks after 'jj' day
                        int profit = prices[jj] - prices[j] + dp[i-1][jj+1];
                        buy = max(buy, profit);
                    }
                }
                dp[i][j] = max(notBuy, buy);
            }
        }
        return dp[2][0];

*/