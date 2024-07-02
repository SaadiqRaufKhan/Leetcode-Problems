// class Solution {
// public:
//     int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
//         int n = obstacleGrid.size();
//         int m = obstacleGrid[0].size();
        
//         cout << "n = " << n << " m = " << m << endl;
        
//         vector<vector<int>> dp(n, vector<int>(m));
        
//         // fill the last 
//         dp[n-1][m-1] = !(obstacleGrid[n-1][m-1]);
//         // fill the base cases 
//         // last row
//         bool rowFlag = false;
//         for(int i=m-2; i>=0; i--) {
//             if(obstacleGrid[n-1][i] == 1) rowFlag = true;
            
//             if(rowFlag) dp[n-1][i] = 0;
//             else dp[n-1][i] = 1;
//         }
        
//         // last col
//         bool colFlag = false;
//         for(int i=n-2; i>=0; i--) {
//             if(obstacleGrid[i][m-1] == 1) colFlag = true;
            
//             if(colFlag) dp[i][m-1] = 0;
//             else dp[i][m-1] = 1;
//         }
            
//         // printing dp array for checking
//         for(int i=0; i<n; i++) {
//             for(int j=0; j<m; j++) {
//                 cout << dp[i][j] << " ";
//             }
//             cout << endl;
//         }
        
//         // fill the remaining cases
//         for(int i=n-2; i>=0; i--) {
//             for(int j=m-2; j>=0; j--) {
//                 if(obstacleGrid[i][j] == 1) {
//                     dp[i][j] = 0;
//                 }
//                 else {
//                     dp[i][j] = dp[i+1][j] + dp[i][j+1];
//                 }
//             }
//         }
        
//         return dp[0][0];
            
//     }
// };    




class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size();
        int n = obstacleGrid[0].size();
        vector<vector<long long>> dp(m, vector<long long>(n, -1));
        
        // last cell
        dp[m-1][n-1] = !(obstacleGrid[m-1][n-1]);
        
        // last column 
        for(int i=m-2; i>=0; i--) {
            // obstacle -> no path
            if(obstacleGrid[i][n-1] == 1) dp[i][n-1] = 0;
            // no obstacle -> copy the below cell
            else dp[i][n-1] = dp[i+1][n-1];
        }
        // last row
        for(int j=n-2; j>=0; j--) {
            // obstacle -> no path
            if(obstacleGrid[m-1][j] == 1) dp[m-1][j] = 0;
            // no obstacle -> copy the right cell
            else dp[m-1][j] = dp[m-1][j+1];
        }
        
        
        // fill the remaining dp table in bottom up manner
        for(int i=m-2; i>=0; i--) {
            for(int j=n-2; j>=0; j--) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }
};


// Recursion + Memoization
// int helper(vector<vector<int>>& obstacleGrid, int i, int j, int m , int n, vector<vector<int>> &dp) {
//     // invalid cell or obstacle found
//     if(i >= m || j >= n || obstacleGrid[i][j] == 1) {
//         return 0;
//     }
//     // reached finish point
//     if(i == m-1 && j == n-1) {
//         return 1;
//     }
//     // already know the ans
//     if(dp[i][j] != -1) {
//         return dp[i][j];
//     }
//     // recursive calls
//     int rans = helper(obstacleGrid, i, j+1, m, n, dp);
//     int dans = helper(obstacleGrid, i+1, j, m, n, dp);
//     dp[i][j] = rans + dans;
//     return dp[i][j];
// }

// int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
//     int m = obstacleGrid.size();
//     int n = obstacleGrid[0].size();
//     vector<vector<int>> dp(m, vector<int>(n, -1));

//     return helper(obstacleGrid, 0, 0, m, n, dp);
// }