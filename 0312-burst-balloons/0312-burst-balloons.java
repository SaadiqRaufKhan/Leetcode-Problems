class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // create a new array and pad '1' at both ends
        int[] nums2 = new int[n+2];
        nums2[0] = 1;
        nums2[n+1] = 1;
        for(int i=0; i<n; i++) {
            nums2[i+1] = nums[i];
        }

        int[][] dp = new int[n+2][n+2]; 
        // we need to burst balloons in the range 1 to n
        // to build the bottom up solution we solve the problem for size 1 to n
        for(int r=1; r<=n; r++) {
            for(int l=r; l>=1; l--) {
                for(int i=l; i<=r; i++) {
                    int lans = dp[l][i-1];  // coins by bursting all balloons on the left
                    int rans = dp[i+1][r];  // coins by bursting all balloons on the right
                    int coins = nums2[l-1] * nums2[i] * nums2[r+1]; // coins by bursting current balloon after every other balloon has been burst
                    coins += lans + rans;
                    dp[l][r] = Math.max(dp[l][r], coins);
                }
            }
        }

        return dp[1][n];
    }
}

/*
class Solution {
    int helper(int[] nums, int l, int r, int[][] dp) {
        if(r < l) return 0;

        if(dp[l][r] != -1) return dp[l][r];

        dp[l][r] = 0;
        // Since all the balloons needs to be burst in the range l to r
        // we pick the ith balloon to be burst at the last, and burst the rest
        for(int i=l; i<=r; i++) {
            int lans = helper(nums, l, i-1, dp);    // coins by bursting all balloons on the left
            int rans = helper(nums, i+1, r, dp);    // coins by bursting all balloons on the right
            
            // since all balloons in the range l to r will be gone by time we burst the ith balloon
            // only the (l-1)th and (r-1)th balloon will be left
            int coins = nums[l-1] * nums[i] * nums[r+1];    // coins by bursting current balloon after every other balloon has been burst
            
            coins += lans + rans;   // total coins for current balloon
            
            dp[l][r] = Math.max(dp[l][r], coins);
        }

        return dp[l][r];
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // create a new array and pad '1' at both ends
        int[] nums2 = new int[n+2];
        nums2[0] = 1;
        nums2[n+1] = 1;
        for(int i=0; i<n; i++) {
            nums2[i+1] = nums[i];
        }

        int[][] dp = new int[n+2][n+2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        // this will give us the max coins by bursting all balloons in [l,r]
        return helper(nums2, 1, n, dp);
    }
}
*/