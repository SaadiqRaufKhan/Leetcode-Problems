
class Solution {
public:
    
    int recursiveHelper(vector<int> prices, int idx, int k) {
        // k reaches 0 or one or no stock left
        if(k == 0 || idx >= prices.size()-1)
            return 0;
        
        // don't buy
        int x = recursiveHelper(prices, idx+1, k);
        
        // buy
        int y = 0;
        for(int i=idx+1; i<prices.size(); i++) {
            if(prices[i] > prices[idx]) {
                int currProfit = prices[i] - prices[idx];
                y = max(y, currProfit + recursiveHelper(prices, i+1, k-1));
            }
        }
        
        return max(x, y);
        
    }
    int maxProfit(int k, vector<int>& prices) {
        // recursive
        // int ans = recursiveHelper(prices, 0, k);
        // return ans;
        
        // DP
        vector<vector<int>> dp(k+1, vector<int>(prices.size()+1, 0));
        
        // fill dp: right to left and up to down
        for(int i=1; i<=k; i++) {
            for(int j=prices.size()-2; j>=0; j--) {
                // not buy curr stock
                int x = dp[i][j+1];
                
                // buy curr stock
                int y = 0;
                for(int l=j+1; l<prices.size(); l++) {
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
};