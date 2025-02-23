class Solution {
public:
    int jump(vector<int>& arr) {

        int n = arr.size();

        // we want to find min so set initially to INT_MAX
        vector<int> dp(n, INT_MAX); 

        // set the last cell to 0 -> base case
        dp[n - 1] = 0;   

        for (int i=n-2; i >= 0; i--) {
            int max_jump = arr[i];
            for (int j = 1; j <= max_jump && i+j < n; j++) {
                if(dp[i+j] != INT_MAX) {
                    dp[i] = min(dp[i], dp[i+j] + 1);
                }
                
            }
        }
        return dp[0];
    }
};