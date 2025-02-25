class Solution {
public:
    int maxProfit(vector<int>& prices) {
        // f[k, i] represents the max profit up until prices[i] (Note: NOT ending with prices[i]) using at most k transactions. 
        // f[k, i] = max(f[k, i-1], prices[i] - prices[j] + f[k-1, j]) { j in range of [0, i-1] }
        //          = max(f[k, i-1], prices[i] + max(f[k-1, j] - prices[j]))
        // f[0, i] = 0; 0 times transation makes 0 profit
        // f[k, 0] = 0; if there is only one price data point you can't make any money no matter how many times you can trade
        if (prices.size() <= 1) return 0;
        int K = 2; // number of max transation allowed
        int maxProf = 0;
        vector<vector<int>> f(K+1, vector<int>(prices.size(), 0));
        for (int k = 1; k <= K; k++) {
            int tmpMax = f[k-1][0] - prices[0];
            for (int i = 1; i < prices.size(); i++) {
                f[k][i] = max(f[k][i-1], prices[i] + tmpMax);
                tmpMax = max(tmpMax, f[k-1][i] - prices[i]);
                maxProf = max(f[k][i], maxProf);
            }
        }
        return maxProf;
        
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