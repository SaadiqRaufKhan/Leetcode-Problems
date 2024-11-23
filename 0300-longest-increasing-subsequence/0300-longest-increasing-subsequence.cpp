class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n+1, 1);
        int maxLIS = 1;

        for(int i=1; i<n; i++) {
            int curr_elem = nums[i];
            for(int j=0; j<i; j++) {
                if(nums[j] < curr_elem && dp[j]+1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    maxLIS = max(maxLIS, dp[i]);
                }
            }
        }

        return maxLIS;
    }
};