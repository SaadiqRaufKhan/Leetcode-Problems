class Solution {
    public int maxProfit(int[] prices) {
        int minTillNow = prices[0];
        int ans = 0;
        
        for(int i=1; i<prices.length; i++) {
            ans = Math.max(ans, prices[i] - minTillNow);
            minTillNow = Math.min(minTillNow, prices[i]);
        }
        return ans;
    }
}