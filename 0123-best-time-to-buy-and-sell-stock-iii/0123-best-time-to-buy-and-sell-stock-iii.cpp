class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.empty()) return 0;

        int firstBuy = INT_MIN, firstSell = 0;
        int secondBuy = INT_MIN, secondSell = 0;

        for (int price : prices) {
            // Buy the first stock (we want the minimum price)
            firstBuy = max(firstBuy, -price);
            
            // Sell the first stock to maximize firstSell
            firstSell = max(firstSell, firstBuy + price);
            
            // Buy the second stock (considering profit from firstSell)
            secondBuy = max(secondBuy, firstSell - price);
            
            // Sell the second stock to maximize secondSell
            secondSell = max(secondSell, secondBuy + price);
        }

        return secondSell;
        
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