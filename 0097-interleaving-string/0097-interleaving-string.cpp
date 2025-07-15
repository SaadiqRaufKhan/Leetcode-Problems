class Solution {
public:
    // DP-tabulation
    bool isInterleave(string s1, string s2, string s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        if(l1+l2 != l3) {
            return false;
        }

        vector<vector<bool>> dp(l1+1, vector<bool>(l2+1));
        // In the DP approach we check if the last characters matches with the last char of any of the two strings 
        // and if so, then we use the answer for shorter subtring using the DP table
        // this approach also works because the last char of s3 must match with last char of s1 or s2 or both 
        for(int i=0; i<=l1; i++) {
            for(int j=0; j<=l2; j++) {
                // both empty
                if(i == 0 && j == 0) {
                    dp[i][j] = true;
                }
                // s1 empty -> match s2 with s3
                else if(i == 0) {
                    dp[i][j] = (s2[j-1] == s3[i+j-1] && dp[i][j-1]);
                }
                // s2 empty -> match s1 with s3
                else if(j == 0) {
                    dp[i][j] = (s1[i-1] == s3[i+j-1] && dp[i-1][j]);
                }
                // both non-empty
                else {
                    dp[i][j] = (s2[j-1] == s3[i+j-1] && dp[i][j-1]) || (s1[i-1] == s3[i+j-1] && dp[i-1][j]);
                }
            }
        }
        return dp[l1][l2];
    
    }
};

/* Recursive Apporach
class Solution {
public:
    // Here we try to match the first chars of s1 and s2 with s3 as opposed to the DP approach where we match the last chars
    // This works because the first char of s3 must match with the first char of s1 or s2 or both
    bool isInterleave(string s1, string s2, string s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        if(l1+l2 != l3) {
            return false;
        }

        if(s1.empty()) {
            return s2 == s3;
        }
        if(s2.empty()) {
            return s1 == s3;
        }
        

        // only s1 match
        if(s1[0] == s3[0] && s2[0] != s3[0]) {
            return isInterleave(s1.substr(1), s2, s3.substr(1));
        }
        // only s2 match
        else if(s1[0] != s3[0] && s2[0] == s3[0]) {
            return isInterleave(s1, s2.substr(1), s3.substr(1));
        }
        // both match
        else if(s1[0] == s3[0] && s2[0] == s3[0]){
            return isInterleave(s1.substr(1), s2, s3.substr(1)) || isInterleave(s1, s2.substr(1), s3.substr(1));
        }

        // both didn't match
        return false;

    }
};
*/