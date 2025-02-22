class Solution {
public:
    // botton-up: DP approach
    int rob(vector<int>& nums) {
        int n = nums.size();
        if(n == 1) {
            return nums[0];
        }
        // dp array to store best answers till that index
        vector<int> dp(n, -1);

        // base cases -> first 2 elements
        dp[0] = nums[0];
        dp[1] = max(nums[0], nums[1]);

        for(int i=2; i<n; i++) {
            // check which of the two produces greater sum: (i) inlcuding curr elem or (ii) excluding curr elem
            dp[i] = max(nums[i] + dp[i-2], dp[i-1]);
        }
        
        return dp[n-1];
    }
};