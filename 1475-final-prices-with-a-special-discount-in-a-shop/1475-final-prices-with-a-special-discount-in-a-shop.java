class Solution {
    public int[] finalPrices(int[] prices) {
        int[] answer = new int[prices.length];
         for(int i=0; i<prices.length; i++) {
             int ans = prices[i];
             for(int j=i+1; j<prices.length; j++) {
                 if(prices[j] <= ans) {
                     ans -= prices[j];
                     break;
                 }
             }
             answer[i] = ans;
         }
        return answer;
    }
}