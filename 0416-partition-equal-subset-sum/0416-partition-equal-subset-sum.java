class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n: nums) sum += n;

        if(sum % 2 != 0) return false;

        sum /= 2;

        int n = nums.length;
        boolean[][] dp = new boolean[n][sum+1];

        // 0th col will be true, because we can always make 0 sum by excluding all elements
        for(int i=0; i<n; i++) {
            dp[i][0] = true;
        }
        // we can make this sum of just one element
        if(nums[0] <= sum) dp[0][nums[0]] = true;

        // fill the remaining dp table
        for(int i=1; i<n; i++) {
            for(int j=1; j<=sum; j++) {
                // exclude
                boolean ans1 = dp[i-1][j];

                // include
                boolean ans2 = false;
                if(nums[i] <= j) {
                    ans2 = dp[i-1][j-nums[i]];
                }
                dp[i][j] = ans1 || ans2;
            }
        }

        return dp[n-1][sum];
    }
}





















// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum = 0;
//         for(int i=0; i<nums.length; i++) {
//             sum += nums[i];
//         }

//         if(sum % 2 == 1) return false;

//         return helper(nums, 0, nums.length, sum/2);
//     }

//     boolean helper(int[] nums, int i, int n, int target) {
//         // System.out.println("Target = " + target + " i = " + i);
//         if(target == 0) return true;

//         if(i == n) return false;

//         // include nums[i]
//         boolean ans1 = false;
//         if(nums[i] <= target) {
//             ans1 = helper(nums, i+1, n, target-nums[i]);    
//         }

//         // exclude nums[i]
//         boolean ans2 = helper(nums, i+1, n, target);

//         return ans1 || ans2;
//     }
// }