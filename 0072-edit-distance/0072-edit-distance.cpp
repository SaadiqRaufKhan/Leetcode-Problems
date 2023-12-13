class Solution {
public:
    int minDistance(string s, string t) {
        int n = s.length();
        int m = t.length();
        
        vector<vector<int>> dp(n+1, vector<int>(m+1, 0)); // (n+1 x m+1)
        
        // base case: one of the strings is empty -> delete other completely
        for(int j=0; j<=m; j++) {
            dp[0][j] = j;
        }
        for(int i=0; i<=n; i++) {
            dp[i][0] = i;
        }
        
        // fill remaining dp (i & j represent the the length of s & t resp.)
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                // ith and jth char match 
                if(s[i-1] == t[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                }
                
                // ith and jth char don't match 
                else {
                    int I = 1 + dp[i-1][j];   // insert
                    int D = 1 + dp[i][j-1];   // delete
                    int R = 1 + dp[i-1][j-1]; // replace
                    dp[i][j] = min({I, D, R});
                }
            }
        }
        return dp[n][m];   
    }
};