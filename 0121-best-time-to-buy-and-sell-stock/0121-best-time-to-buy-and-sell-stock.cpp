class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int maxProfit = 0;
        int minStock = INT_MAX;
        for(int i=0; i<prices.size(); i++) {
            // first update the minStock value if possible
            minStock = min(minStock, prices[i]);

            // then compute the profit
            int currProfit = prices[i] - minStock;
            if(currProfit > maxProfit) {
                maxProfit = currProfit;
            }
        }

        return maxProfit;
    }
};