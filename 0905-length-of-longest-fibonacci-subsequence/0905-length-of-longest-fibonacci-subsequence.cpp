class Solution {
public:
    int lenLongestFibSubseq(vector<int>& arr) {
        int n = arr.size();
        map<int, int> m;
        // for quickly accessing the indices
        for(int i=0; i<n; i++) { 
            m[arr[i]] = i;
        }

        // dp[i][j] --> length of longest fib seq ending with arr[i], arr[j]
        vector<vector<int>> dp(n, vector<int>(n,2));
        int ans = 2;
        for(int j=2; j<n; j++) {
            for(int i=j-1; i>=0; i--) {
                int target = arr[j] - arr[i];
                if(m.find(target) != m.end() && m[target] < i) {
                    dp[i][j] = max(dp[i][j], dp[m[target]][i] + 1);
                    ans = max(dp[i][j], ans);
                }
            }
        }
        return (ans == 2) ? 0 : ans;
    }
};