class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        
        int[] dp = new int[amount+1];
        
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for(int i=1; i<=amount; i++) {
            ArrayList<Integer> indices = new ArrayList<>();
            int j = 0;
            while(j < coins.length && coins[j] <= i) {
                indices.add(i - coins[j]);
                j++;
            }
            
            int ans = Integer.MAX_VALUE;
            for(int index: indices) {
                if(dp[index] != -1) {
                    ans = Math.min(ans, dp[index]+1);
                }
            }
            if(ans != Integer.MAX_VALUE) {
                dp[i] = ans;
            }
        }
        return dp[amount];
    }
}