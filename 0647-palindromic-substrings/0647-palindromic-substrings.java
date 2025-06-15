class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;

        boolean[][] dp = new boolean[n][n];

        for(int i=0; i<n; i++) {
            dp[i][i] = true;
            ans++;
        }

        for(int i=0; i<=n-2; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                ans++;
            }
        }

        for(int len=3; len<=n; len++) {
            for(int i=0; i<=n-len; i++) {
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}