class Solution {
public:
    int minimumTotal(vector<vector<int> > &triangle) {
        // copy the last row of triangle in another vector
        vector<int> mini = triangle[triangle.size()-1];

        // use the rows above it to minimize the ans
        for(int i=triangle.size()-2; i>=0 ; i--) {
            for(int j=0; j<triangle[i].size(); j++) {
                mini[j] = triangle[i][j] + min(mini[j],mini[j+1]);
            }
        }
        return mini[0];
    }

    // Recursive + Memoization approach
    // int helper(vector<vector<int>> triangle, int i, int j, int n, vector<vector<int>> &dp) {
    //     if(i == n) {
    //         return 0;
    //     }
    //     if(dp[i][j] != -1) {
    //         return dp[i][j];
    //     }

    //     int ans1 = triangle[i][j] + helper(triangle, i+1, j, n, dp);
    //     int ans2 = triangle[i][j] + helper(triangle, i+1, j+1, n, dp);
    //     dp[i][j] = min(ans1, ans2);
    //     return dp[i][j];
    // }
    // int minimumTotal(vector<vector<int>>& triangle) {
    //     // depth of triangle -> upper limit on j
    //     vector<vector<int>> dp(triangle.size(), vector<int>(triangle.size(), -1));
    //     int n = triangle.size(); 
    //     return helper(triangle, 0, 0, n, dp);
    // }
};