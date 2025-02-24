class Solution {
public:
    int maxProfit(vector<int>& prices) {
        vector<int> dp(prices.size(), 0);
        for(int i=1; i<prices.size(); i++) {
            dp[i] = dp[i-1];
            for(int j=i-1; j>=0; j--) {
                if(prices[j] < prices[i]) {
                    int max_profit = max(dp[i-1], dp[j] + prices[i]-prices[j]);
                    dp[i] = max(dp[i], max_profit);
                }
            }
        }
        // for(int n: dp) {
        //     cout << n << " ";
        // }
        return dp[prices.size()-1];
    }
};