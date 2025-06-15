class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int ans = 1; // min-possible
        // approach similar to substring variation but here we rely more on dp table
        for(int i=0; i<n; i++) dp[i][i] = 1;
        for(int i=0; i<n-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = 2;
                ans = 2;
            }
            else dp[i][i+1] = 1;
        }

        // make the dp table on paper, then try to visualize 
        for(int len=3; len<=n; len++) {
            for(int i=0; i<=n-len; i++) {
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}



// Recursive
/*
    int helper(String s, int l, int r) {
        if(l == r) return 1; // one char
        if(l > r) return 0;  // 'aa' case will make this call

        // end chars match: return 2 + ans of remaining string
        if(s.charAt(l)== s.charAt(r)) {
            return 2 +  helper(s, l+1, r-1);
        }
        return max(helper(s, l+1, r), helper(s, l, r-1));
    }
    int longestPalindromeSubseq(String s) {
        return helper(s, 0, s.length()-1);
    }
*/