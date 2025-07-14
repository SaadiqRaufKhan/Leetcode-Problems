
class Solution {
public:
    
    // int recursiveHelper(vector<int> prices, int idx, int k) {
    //     // k reaches 0 or one or no stock left
    //     if(k == 0 || idx >= prices.size()-1)
    //         return 0;
        
    //     // don't buy
    //     int x = recursiveHelper(prices, idx+1, k);
        
    //     // buy
    //     int y = 0;
    //     for(int i=idx+1; i<prices.size(); i++) {
    //         if(prices[i] > prices[idx]) {
    //             int currProfit = prices[i] - prices[idx];
    //             y = max(y, currProfit + recursiveHelper(prices, i+1, k-1));
    //         }
    //     }
        
    //     return max(x, y);
        
    // }

    /* 
    int maxProfit(int k, vector<int>& prices) {
        // recursive
        // int ans = recursiveHelper(prices, 0, k);
        // return ans;
        
        // DP
        int n = prices.size();
        vector<vector<int>> dp(k+1, vector<int>(n+1, 0));
        
        // fill dp: right to left and up to down
        for(int i=1; i<=k; i++) {
            // start j from 2nd last element so that we have at least two 2 days for buying and selling
            for(int j=n-2; j>=0; j--) {
                // not buy curr stock
                int x = dp[i][j+1];
                
                // buy curr stock
                int y = 0;
                for(int l=j+1; l<n; l++) {
                    if(prices[l] > prices[j]) {
                        int currProf = prices[l] - prices[j];
                        y = max(y, currProf + dp[i-1][l+1]);
                    }
                }
                dp[i][j] = max(x, y);
            }
        }
        return dp[k][0];
    }
    */
    int maxProfit(int K, vector<int>& prices) {
        if (prices.size() <= 1) return 0;
        // int K = 2; // number of max transation allowed
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