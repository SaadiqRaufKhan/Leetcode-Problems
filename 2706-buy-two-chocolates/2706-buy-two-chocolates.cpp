class Solution {
public:
    int buyChoco(vector<int>& prices, int money) {
        int min1 = 1e9;
        int min2 = 1e9;
        
        for(int i=0; i<prices.size(); i++) {
            if(prices[i] < min1) {
                min2 = min1;
                min1 = prices[i];
            }
            else if(prices[i] < min2) {
                min2 = prices[i];
            }
        }
        
        int res = money - (min1 + min2);
        
        return (res >= 0) ? res : money;
    }
};